package IHM.Plateau;

import IHM.Plateau.CartePiocher.CaisseCommune;

import IHM.Plateau.LieuPublic.*;
import IHM.Plateau.LieuPublic.Gare.GareLyon;
import IHM.Plateau.LieuPublic.Gare.GareMontparnasse;
import IHM.Plateau.LieuPublic.Gare.GareNord;
import IHM.Plateau.LieuPublic.Gare.GareSaintLazare;
import IHM.Plateau.Terrains.BleuCiel.CaseCourcelles;
import IHM.Plateau.Terrains.BleuCiel.CaseRepublique;
import IHM.Plateau.Terrains.BleuCiel.CaseVaugirard;
import IHM.Plateau.Terrains.BleuFonce.CaseChampsElysees;
import IHM.Plateau.Terrains.BleuFonce.CasePaix;
import IHM.Plateau.Terrains.Jaune.CaseBourse;
import IHM.Plateau.Terrains.Jaune.CaseFayette;
import IHM.Plateau.Terrains.Jaune.CaseHonore;
import IHM.Plateau.Terrains.Marron.CaseBelleville;
import IHM.Plateau.Terrains.Marron.CaseLecourbe;
import IHM.Plateau.Terrains.Orange.CaseMozart;
import IHM.Plateau.Terrains.Orange.CasePigalle;
import IHM.Plateau.Terrains.Orange.CaseSaintMichelle;
import IHM.Plateau.Terrains.Rose.CaseNeuilly;
import IHM.Plateau.Terrains.Rose.CaseParadis;
import IHM.Plateau.Terrains.Rose.CaseVillette;
import IHM.Plateau.Terrains.Rouge.CaseHenriMartin;
import IHM.Plateau.Terrains.Rouge.CaseMalsherbes;
import IHM.Plateau.Terrains.Rouge.CaseMatignon;
import IHM.Plateau.Terrains.Vert.CaseBreteuil;
import IHM.Plateau.Terrains.Vert.CaseCapucine;
import IHM.Plateau.Terrains.Vert.CaseFoch;
import Metier.Plateau.Cases;

public class Fabrique {

    public Fabrique(){

    }

    public VueCases FabriqueCase(Cases caseMetier)
    {
        VueCases c= null ;
        switch(caseMetier.toString()){

            //CASES DU BAS
            case "Départ": c= new Depart(caseMetier);
            break;

           case "Boul. de Belleville" : c = new CaseBelleville(caseMetier);
            break ;
            case "Caisse Commune": c = new CaisseCommune(caseMetier);
            break ;
            case "Rue Lecourbe" : c = new CaseLecourbe(caseMetier);
            break ;

            case "Impot sur le Revenu": c = new Impot(caseMetier);
            break ;

            case "Gare de Montparmasse": c = new GareMontparnasse(caseMetier);
            break;

            case "Rue de Vaugirard" : c = new CaseVaugirard(caseMetier);
            break;
            case "Chance" : c = new Chance(caseMetier);
            break ;
            case "Rue de Courcelles" : c = new CaseCourcelles(caseMetier);
            break;
            case "Avenue de la République" : c = new CaseRepublique(caseMetier);
            break ;

            case "Prison": c = new Prison(caseMetier);
            break;


            //CASES DE GAUCHES
            case "Boul. de la Villette": c = new CaseVillette(caseMetier);
            break ;
            case "Ampoule": c = new Ampoule(caseMetier);
            break;
            case "Avenue de Neuilly" : c = new CaseNeuilly(caseMetier);
            break ;
            case "Rue du Paradis" : c = new CaseParadis(caseMetier);
            break ;

            case "Gare de Lyon": c = new GareLyon(caseMetier);
            break;

            case "Avenue Mozart" : c = new CaseMozart(caseMetier);
            break ;
            case "Boul. Saint-Michel" : c = new CaseSaintMichelle(caseMetier);
            break;
            case "Place Pigale": c = new CasePigalle(caseMetier);
            break ;

            case "ParcGratuit": c = new ParcGratuit(caseMetier);
            break;

            //CASE DU HAUT
            case "Avenue Matignon" : c = new CaseMatignon(caseMetier);
            break ;
            case "Boul. Malesherbes" : c = new CaseMalsherbes(caseMetier);
            break;
            case "Avenue Henri-Martin" : c = new CaseHenriMartin(caseMetier);
            break ;

            case "Gare du Nord": c = new GareNord(caseMetier);
            break;

            case "Faubourg Saint-Honoré": c = new CaseHonore(caseMetier);
            break ;
            case "Place de la Bourse": c = new CaseBourse(caseMetier);
            break ;
            case "Rue Lafayette" : c = new CaseFayette(caseMetier);
            break ;

            case "Robinet": c = new Robinet(caseMetier);
            break;

            case "Aller en prison": c = new AllezPrison(caseMetier);
            break;

            //CASES DE DROITES
            case "Avenue de Breteuil" : c = new CaseBreteuil(caseMetier);
            break ;
            case "Avenue Foch" : c = new CaseFoch(caseMetier);
            break ;
            case "Boul. des Capucines": c = new CaseCapucine(caseMetier);
            break ;

            case "Gare de Saint-Lazare": c = new GareSaintLazare(caseMetier);
            break ;
            case "Avenue des Champs-Elysées" : c = new CaseChampsElysees(caseMetier);
            break;

            case "TaxeDeLuxe": c = new TaxeDeLuxe(caseMetier);
            break;
            case "Rue de la Paix": c = new CasePaix(caseMetier);
            break ;

            //PAR DEFAUT
            default: c= null;
        }
        return c;
    }
}
