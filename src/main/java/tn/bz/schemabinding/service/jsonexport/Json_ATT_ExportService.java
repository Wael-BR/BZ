package tn.bz.schemabinding.service.jsonexport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import tn.bz.schemabinding.entity.dto.MAJ_CRS_ATT.*;

import java.util.*;

@Service
public class Json_ATT_ExportService {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public List<Map<String, Object>> fetchData() {
        String sql = "SELECT * FROM [spring].[dbo].[majcrsatt]";
        return jdbcTemplate.queryForList(sql);
    }

    public DocumentWrapper convertToDocument(List<Map<String, Object>> rows) {
        if (rows.isEmpty()) return null;

        DocumentWrapper wrapper = new DocumentWrapper();
        Document document = new Document();

        Map<String, Object> first = rows.get(0);
        EnteteDoc enteteDoc = new EnteteDoc();
        enteteDoc.setCodeIAT(toString(first.get("EnteteDoc_CodeIAT")));
        enteteDoc.setDateDec(toString(first.get("EnteteDoc_DateDec")));
        enteteDoc.setCodeAnnexe(toString(first.get("EnteteDoc_CodeAnnexe")));
        enteteDoc.setPeriodDec(toString(first.get("EnteteDoc_PeriodDec")));
        document.setEnteteDoc(enteteDoc);

        List<ExtraitWrapper> extraits = new ArrayList<>();

        for (Map<String, Object> row : rows) {
            Extrait extrait = new Extrait();
            Entete entete = new Entete();
            entete.setAgenceDom(toString(row.get("Entete_AgenceDom")));

            Titulaire titulaire = new Titulaire();
            titulaire.setTypeTitul(toString(row.get("Titulaire_TypeTitul")));
            titulaire.setTypeIdentifiant(toString(row.get("Titulaire_TypeIdentifiant")));
            titulaire.setCodeIdentifiant(toString(row.get("Titulaire_CodeIdentifiant")));
            titulaire.setNom(toString(row.get("Titulaire_Nom")));
            titulaire.setPrenom(toString(row.get("Titulaire_Prenom")));
            titulaire.setRaisSociale(toString(row.get("Titulaire_RaisSociale")));
            titulaire.setNationalite(toString(row.get("Titulaire_Nationalite")));
            entete.setTitulaire(titulaire);

            RefCompte compte = new RefCompte();
            compte.setRib(toString(row.get("RefCompte_Rib")));
            compte.setDateOuvCpte(toString(row.get("RefCompte_DateOuvCpte")));
            compte.setEtatCpte(toString(row.get("RefCompte_EtatCpte")));
            compte.setDateclotureCpte(toString(row.get("RefCompte_DateclotureCpte")));
            compte.setDateGelCpte(toString(row.get("RefCompte_DateGelCpte")));

            Amount soldDeb = new Amount();
            soldDeb.setValue(toString(row.get("SoldDebMois_Value")));
            soldDeb.setCcy(toString(row.get("SoldDebMois_Ccy")));
            compte.setSoldDebMois(soldDeb);

            Amount soldFin = new Amount();
            soldFin.setValue(toString(row.get("SoldfinMois_Value")));
            soldFin.setCcy(toString(row.get("SoldfinMois_Ccy")));
            compte.setSoldfinMois(soldFin);

            entete.setRefCompte(compte);
            entete.setNbrEcritures(toInteger(row.get("Entete_NbrEcritures")));
            extrait.setEntete(entete);

            Detail detail = new Detail();
            detail.setRib(toString(row.get("Detail_Rib")));

            RefOperation operation = new RefOperation();
            operation.setNatMvtOp(toString(row.get("RefOperation_NatMvtOp")));
            operation.setCodMvt(toString(row.get("RefOperation_CodMvt")));
            operation.setDateMvt(toString(row.get("RefOperation_DateMvt")));
            operation.setNatOp(toString(row.get("RefOperation_NatOp")));
            operation.setModReg(toString(row.get("RefOperation_ModReg")));
            operation.setNumMsgeSwiftMvt(toString(row.get("RefOperation_NumMsgeSwiftMvt")));

            Amount mntDev = new Amount();
            mntDev.setValue(toString(row.get("MntOpDev_Value")));
            mntDev.setCcy(toString(row.get("MntOpDev_Ccy")));
            operation.setMntOpDev(mntDev);

            Amount mntDin = new Amount();
            mntDin.setValue(toString(row.get("MntOpDin_Value")));
            mntDin.setCcy(toString(row.get("MntOpDin_Ccy")));
            operation.setMntOpDin(mntDin);

            detail.setRefOperation(operation);

            RefAutorisationBct bct = new RefAutorisationBct();
            bct.setNumAutBCT(toString(row.get("RefAutorisationBct_NumAutBCT")));
            bct.setDateAutBCT(toString(row.get("RefAutorisationBct_DateAutBCT")));
            detail.setRefAutorisationBct(bct);

            detail.setDenomBenif(toString(row.get("Detail_DenomBenif")));
            detail.setPays(toString(row.get("Detail_Pays")));

            DetailWrapper detailWrapper = new DetailWrapper();
            detailWrapper.setDetail(detail);
            extrait.setDetails(List.of(detailWrapper));

            ExtraitWrapper extraitWrapper = new ExtraitWrapper();
            extraitWrapper.setExtrait(extrait);
            extraits.add(extraitWrapper);
        }

        document.setExtraits(extraits);
        wrapper.setDocument(document);
        return wrapper;
    }

    private String toString(Object value) {
        return value == null ? null : value.toString();
    }

    private Integer toInteger(Object value) {
        if (value == null) return null;
        if (value instanceof Integer) return (Integer) value;
        try {
            return Integer.parseInt(value.toString());
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("Cannot convert to Integer: " + value);
        }
    }
}
