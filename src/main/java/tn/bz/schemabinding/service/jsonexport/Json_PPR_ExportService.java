package tn.bz.schemabinding.service.jsonexport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import tn.bz.schemabinding.entity.dto.CRS_PPR_V2.*;

import java.util.*;

@Service
public class Json_PPR_ExportService {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public List<Map<String, Object>> fetchRawData() {
        String sql = "SELECT * FROM [spring].[dbo].[crspprv2]";
        return jdbcTemplate.queryForList(sql);
    }

    public DocumentWrapper convertToDocument(List<Map<String, Object>> rows) {
        if (rows.isEmpty()) return null;

        DocumentWrapper wrapper = new DocumentWrapper();
        Document doc = new Document();
        EnteteDoc enteteDoc = new EnteteDoc();

        Map<String, Object> first = rows.get(0);
        enteteDoc.setCodeIAT(String.valueOf(first.get("EnteteDoc_CodeIAT")));
        enteteDoc.setDateDec(String.valueOf(first.get("EnteteDoc_DateDec")));
        enteteDoc.setCodeAnnexe(String.valueOf(first.get("EnteteDoc_CodeAnnexe")));
        enteteDoc.setPeriodDec(String.valueOf(first.get("EnteteDoc_PeriodDec")));
        doc.setEnteteDoc(enteteDoc);

        List<ExtraitWrapper> extraits = new ArrayList<>();
        for (Map<String, Object> row : rows) {
            ExtraitWrapper extraitWrapper = new ExtraitWrapper();
            Extrait extrait = new Extrait();
            Entete entete = new Entete();
            entete.setAgenceDom(String.valueOf(row.get("Entete_AgenceDom")));

            Titulaire titulaire = new Titulaire();
            titulaire.setTypeIdentifiant(String.valueOf(row.get("Titulaire_TypeIdentifiant")));
            titulaire.setCodeIdentifiant(String.valueOf(row.get("Titulaire_CodeIdentifiant")));
            titulaire.setNom(String.valueOf(row.get("Titulaire_Nom")));
            titulaire.setPrenom(String.valueOf(row.get("Titulaire_Prenom")));
            titulaire.setNationalite(String.valueOf(row.get("Titulaire_Nationalite")));
            entete.setTitulaire(titulaire);

            RefCompte compte = new RefCompte();
            compte.setRib(String.valueOf(row.get("RefCompte_Rib")));
            compte.setDeviseCpte(String.valueOf(row.get("RefCompte_DeviseCpte")));
            compte.setDateOuvCpte(String.valueOf(row.get("RefCompte_DateOuvCpte")));
            compte.setEtatCpte(String.valueOf(row.get("RefCompte_EtatCpte")));
            compte.setDateclotureCpte(String.valueOf(row.get("RefCompte_DateclotureCpte")));
            compte.setDateGelCpte(String.valueOf(row.get("RefCompte_DateGelCpte")));
            compte.setNumAutBCT(String.valueOf(row.get("RefCompte_NumAutBCT")));
            compte.setDateAutBCT(String.valueOf(row.get("RefCompte_DateAutBCT")));

            Amount soldDeb = new Amount();
            soldDeb.setValue(String.valueOf(row.get("SoldDebMois_Value")));
            soldDeb.setCcy(String.valueOf(row.get("SoldDebMois_Ccy")));
            compte.setSoldDebMois(soldDeb);

            Amount soldFin = new Amount();
            soldFin.setValue(String.valueOf(row.get("SoldfinMois_Value")));
            soldFin.setCcy(String.valueOf(row.get("SoldfinMois_Ccy")));
            compte.setSoldfinMois(soldFin);

            entete.setRefCompte(compte);

            Object rawNbrEcritures = row.get("Entete_NbrEcritures");
            Integer nbrEcritures = null;
            if (rawNbrEcritures != null) {
                try {
                    nbrEcritures = Integer.parseInt(rawNbrEcritures.toString());
                } catch (NumberFormatException e) {
                    nbrEcritures = 0;
                }
            }
            entete.setNbrEcritures(nbrEcritures);

            extrait.setEntete(entete);

            DetailWrapper detailWrapper = new DetailWrapper();
            Detail detail = new Detail();
            detail.setRib(String.valueOf(row.get("Detail_Rib")));

            RefOperation op = new RefOperation();
            op.setNatMvtOp(String.valueOf(row.get("RefOperation_NatMvtOp")));
            Amount mntDev = new Amount();
            mntDev.setValue(String.valueOf(row.get("MntOpDev_Value")));
            mntDev.setCcy(String.valueOf(row.get("MntOpDev_Ccy")));
            op.setMntOpDev(mntDev);
            Amount mntDin = new Amount();
            mntDin.setValue(String.valueOf(row.get("MntOpDin_Value")));
            mntDin.setCcy(String.valueOf(row.get("MntOpDin_Ccy")));
            op.setMntOpDin(mntDin);
            op.setDateMvt(String.valueOf(row.get("RefOperation_DateMvt")));
            op.setCodMvt(String.valueOf(row.get("RefOperation_CodMvt")));
            op.setNatOp(String.valueOf(row.get("RefOperation_NatOp")));
            op.setModReg(String.valueOf(row.get("RefOperation_ModReg")));
            op.setNumMsgeSwiftMvt(String.valueOf(row.get("RefOperation_NumMsgeSwiftMvt")));
            detail.setRefOperation(op);

            RefFicheInformation fiche = new RefFicheInformation();
            fiche.setNumFicheInformation(String.valueOf(row.get("RefFicheInformation_NumFicheInformation")));
            fiche.setDateFicheInformation(String.valueOf(row.get("RefFicheInformation_DateFicheInformation")));
            detail.setRefFicheInformation(fiche);

            RefAutorisationBct bct = new RefAutorisationBct();
            bct.setNumAutBCT(String.valueOf(row.get("RefAutorisationBct_NumAutBCT")));
            bct.setDateAutBCT(String.valueOf(row.get("RefAutorisationBct_DateAutBCT")));
            detail.setRefAutorisationBct(bct);

            DecDouane dec = new DecDouane();
            dec.setNumDecD(String.valueOf(row.get("DecDouane_NumDecD")));
            dec.setDateDecD(String.valueOf(row.get("DecDouane_DateDecD")));
            detail.setDecDouane(dec);

            detail.setDenomBenif(String.valueOf(row.get("Detail_DenomBenif")));
            detail.setPays(String.valueOf(row.get("Detail_Pays")));
            detailWrapper.setDetail(detail);

            extrait.setDetails(List.of(detailWrapper));
            extraitWrapper.setExtrait(extrait);
            extraits.add(extraitWrapper);
        }

        doc.setExtraits(extraits);
        wrapper.setDocument(doc);
        return wrapper;
    }
}
