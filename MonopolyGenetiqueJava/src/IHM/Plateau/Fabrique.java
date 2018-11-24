package IHM.Plateau;


import IHM.Plateau.CartePiocher.CaisseCommune;
import IHM.Plateau.CartePiocher.ParcGratuit;
import IHM.Plateau.LieuPublic.*;
import IHM.Plateau.LieuPublic.Gare.GareLyon;
import IHM.Plateau.LieuPublic.Gare.GareMontparnasse;
import IHM.Plateau.Terrains.BleuCiel.CaseCourcelles;
import IHM.Plateau.Terrains.BleuCiel.CaseRepublique;
import IHM.Plateau.Terrains.BleuCiel.CaseVaugirard;
import IHM.Plateau.Terrains.Marron.CaseBelleville;
import IHM.Plateau.Terrains.Marron.CaseLecourbe;
import IHM.Plateau.Terrains.Orange.CaseMozart;
import IHM.Plateau.Terrains.Orange.CasePigalle;
import IHM.Plateau.Terrains.Orange.CaseSaintMichelle;
import IHM.Plateau.Terrains.Rose.CaseNeuilly;
import IHM.Plateau.Terrains.Rose.CaseParadis;
import IHM.Plateau.Terrains.Rose.CaseVillette;
import Metier.Plateau.Cases;

public class Fabrique {

    public Fabrique(){

    }

    public VueCases FabriqueCase(Cases caseMetier)
    {
        VueCases c= null ;
        switch(caseMetier.toString()){

            //CASES DU BAS
            case "Départ": c= new Depart(caseMetier, c.getListeCases());
            break;

            case "Boul. de Belleville" : c = new CaseBelleville(caseMetier, c.getListeCases());
            break ;
            case "Caisse Commune": c = new CaisseCommune(caseMetier, c.getListeCases());
            break ;
            case "Rue Lecourbe" : c = new CaseLecourbe(caseMetier, c.getListeCases());
            break ;

            case "Impot sur le Revenu": c = new Impot(caseMetier, c.getListeCases());
            break ;

            case "Gare de Montparmasse": c = new GareMontparnasse(caseMetier, c.getListeCases());
            break;

            case "Rue de Vaugirard" : c = new CaseVaugirard(caseMetier, c.getListeCases());
            break;
            case "Chance" : c = new Chance(caseMetier, c.getListeCases());
            break ;
            case "Rue de Courcelles" : c = new CaseCourcelles(caseMetier, c.getListeCases());
            break;
            case "Avenue de la République" : c = new CaseRepublique(caseMetier, c.getListeCases());
            break ;

            case "Prison": c = new Prison(caseMetier, c.getListeCases());
            break;


            //CASES DE GAUCHES
            case "Boul. de la Villette": c = new CaseVillette(caseMetier, c.getListeCases());
            break ;
            case "Ampoule": c = new Ampoule(caseMetier, c.getListeCases());
            break;
            case "Avenue de Neuilly" : c = new CaseNeuilly(caseMetier, c.getListeCases());
            break ;
            case "Rue du Paradis" : c = new CaseParadis(caseMetier, c.getListeCases());
            break ;

            case "Gare de Lyon": c = new GareLyon(caseMetier, c.getListeCases());
            break;

            case "Avenue de Mozart" : c = new CaseMozart(caseMetier, c.getListeCases());
            break ;
            case "Boul. Saint Michelle" : c = new CaseSaintMichelle(caseMetier,c.getListeCases());
            break;
            case "Place Pigalle": c = new CasePigalle(caseMetier, c.getListeCases());
            break ;

            case "ParcGratuit": c = new ParcGratuit(caseMetier, c.getListeCases());
            break;

            //CASE DU HAUT
            

            case "Robinet": c = new Robinet(caseMetier, c.getListeCases());
            break;
            case "TaxeDeLuxe": c = new TaxeDeLuxe(caseMetier, c.getListeCases());
            break;
            case "Impot": c = new Impot(caseMetier, c.getListeCases());
            break;


            default: c= null;
        }
        return c;
    }
}
