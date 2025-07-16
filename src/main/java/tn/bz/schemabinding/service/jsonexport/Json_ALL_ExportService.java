package tn.bz.schemabinding.service.jsonexport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import tn.bz.schemabinding.entity.dto.MAJ_CRS_ALL_TNDCV_V3.*;

import java.util.*;

@Service
public class Json_ALL_ExportService {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public List<Map<String, Object>> fetchRawData() {
        String sql = "SELECT * FROM [spring].[dbo].[majcrsalltndcvv3]";
        return jdbcTemplate.queryForList(sql);
    }

    public DocumentWrapper convertToDocument(List<Map<String, Object>> rows) {
        if (rows.isEmpty()) return null;

        DocumentWrapper wrapper = new DocumentWrapper();
        Document document = new Document();

        Map<String, Object> first = rows.get(0);
        EnteteDoc enteteDoc = new EnteteDoc();
        enteteDoc.setCodeIAT((String) first.get("EnteteDoc_CodeIAT"));
        enteteDoc.setDateDec(String.valueOf(first.get("EnteteDoc_DateDec")));
        enteteDoc.setCodeAnnexe((String) first.get("EnteteDoc_CodeAnnexe"));
        enteteDoc.setAnneDec((String) first.get("EnteteDoc_AnneDec"));
        enteteDoc.setPeriodDec((String) first.get("EnteteDoc_PeriodDec"));
        document.setEnteteDoc(enteteDoc);

        List<ExtraitWrapper> extraits = new ArrayList<>();
        for (Map<String, Object> row : rows) {
            Entete entete = new Entete();
            entete.setAgenceDom((String) row.get("Entete_AgenceDom"));

            Titulaire titulaire = new Titulaire();
            titulaire.setTypeIdentifiant((String) row.get("Titulaire_TypeIdentifiant"));
            titulaire.setCodeIdentifiant((String) row.get("Titulaire_CodeIdentifiant"));
            titulaire.setNom((String) row.get("Titulaire_Nom"));
            titulaire.setPrenom((String) row.get("Titulaire_Prenom"));
            titulaire.setNationalite((String) row.get("Titulaire_Nationalite"));
            entete.setTitulaire(titulaire);

            RefCompte compte = new RefCompte();
            compte.setRib((String) row.get("RefCompte_Rib"));
            compte.setDateOuvCpte(String.valueOf(row.get("RefCompte_DateOuvCpte")));
            compte.setEtatCpte((String) row.get("RefCompte_EtatCpte"));
            compte.setDateclotureCpte(String.valueOf(row.get("RefCompte_DateclotureCpte")));
            compte.setDateGelCpte(String.valueOf(row.get("RefCompte_DateGelCpte")));

            Amount deb = new Amount();
            deb.setValue(String.valueOf(row.get("SoldDebMois_Value")));
            deb.setCcy((String) row.get("SoldDebMois_Ccy"));
            compte.setSoldDebMois(deb);

            Amount fin = new Amount();
            fin.setValue(String.valueOf(row.get("SoldfinMois_Value")));
            fin.setCcy((String) row.get("SoldfinMois_Ccy"));
            compte.setSoldfinMois(fin);

            entete.setRefCompte(compte);
            entete.setNbrEcritures(getInteger(row.get("Entete_NbrEcritures")));

            List<DetailWrapper> details = new ArrayList<>();
            Detail detail = new Detail();
            detail.setRib((String) row.get("Detail_Rib"));

            RefOperation op = new RefOperation();
            op.setNatMvtOp((String) row.get("RefOperation_NatMvtOp"));
            op.setDateMvt(String.valueOf(row.get("RefOperation_DateMvt")));
            op.setDateRetVoy(String.valueOf(row.get("RefOperation_DateRetVoy")));
            op.setCodMvt((String) row.get("RefOperation_CodMvt"));
            op.setNatOp((String) row.get("RefOperation_NatOp"));
            op.setModReg((String) row.get("RefOperation_ModReg"));
            op.setNumMsgeSwiftMvt((String) row.get("RefOperation_NumMsgeSwiftMvt"));

            Amount dev = new Amount();
            dev.setValue(String.valueOf(row.get("MntOpDev_Value")));
            dev.setCcy((String) row.get("MntOpDev_Ccy"));
            op.setMntOpDev(dev);

            Amount din = new Amount();
            din.setValue(String.valueOf(row.get("MntOpDin_Value")));
            din.setCcy((String) row.get("MntOpDin_Ccy"));
            op.setMntOpDin(din);
            detail.setRefOperation(op);

            RefAutorisationBct bct = new RefAutorisationBct();
            bct.setNumAutBCT((String) row.get("RefAutorisationBct_NumAutBCT"));
            bct.setDateAutBCT(String.valueOf(row.get("RefAutorisationBct_DateAutBCT")));
            detail.setRefAutorisationBct(bct);

            detail.setDenomBenif((String) row.get("Detail_DenomBenif"));
            detail.setPays((String) row.get("Detail_Pays"));

            DetailWrapper dw = new DetailWrapper();
            dw.setDetail(detail);
            details.add(dw);

            Extrait extrait = new Extrait();
            extrait.setEntete(entete);
            extrait.setDetails(details);

            ExtraitWrapper ew = new ExtraitWrapper();
            ew.setExtrait(extrait);
            extraits.add(ew);
        }

        document.setExtraits(extraits);
        wrapper.setDocument(document);
        return wrapper;
    }

    private Integer getInteger(Object val) {
        if (val == null) return null;
        if (val instanceof Integer) return (Integer) val;
        try {
            return Integer.parseInt(val.toString());
        } catch (NumberFormatException e) {
            return null;
        }
    }
}
