package szenario;

import window.Window;


public class Szenario2 extends Szenario {

	public Szenario2(Window w) {
		super(w);
	}

	@Override
	public void start() {
		w.printQuestion(newQuestion = "Guten Tag! Wie kann ich Ihnen helfen?");
	}

	@Override
	public String toString() {
		return "Szenario zwei";
	}

	@Override
	public void cases(String answer) {
		switch(progress) {
		case 0:
			if (answer.equals("Hallo. Ich brauche ein neues Smartphone. Mein altes Ger�t gen�gt meinen Anforderungen nicht mehr.")) {
				newQuestion = "Sie besitzen also schon eines. Was st�rt sie an ihrem alten Smartphone insbesondere?";
				progress++;
			} else {
				falseQuestion();
			}
			break;
		case 1:
			if (answer.equals("Es ist schwer zu bedienen und hat viel zu wenig Speicher.")) {
				newQuestion = "Inwiefern ist es schwer zu bedienen?";
				progress++;
			} else {
				falseQuestion();
			}
			break;
		case 2:
			if (answer.equals("Das Display ist recht klein und man muss relativ fest drauf dr�cken damit es auf Eingaben reagiert.")) {
				sql = "select * from Smartphones where Displaygroesse >= '4'";
				newQuestion = "Sie suchen also ein Smartphone mit gro�em kapazitivem Display. M�chten Sie es auch �ber eine Hardware-Tastatur bedienen k�nnen?";
				progress++;
			} else {
				falseQuestion();
			}
			break;
		case 3:
			if (answer.equals("Nein, der Bildschirm sollte aber gro� genug f�r bequemes schreiben mit den Fingern sein.")) {
				sql = sql + " and Hardwaretastatur = '0'";
				newQuestion = "Wie wichtig sind Ihnen Multimedia-F�higkeiten?";
				progress++;
			} else {
				falseQuestion();
			}
			break;
		case 4:
			if (answer.equals("Diese sind mir sehr wichtig.")) {
				newQuestion = "M�chten Sie mit ihrem Smartphone Bilder und Videos in hoher Qualit�t aufnehmen?";
				progress++;
			} else {
				falseQuestion();
			}
			break;
		case 5:
			if (answer.equals("Auf jeden Fall.")) {
				sql = sql + " and `Interner Speicher` >= '8000'";
				newQuestion = "<html>Wenn Sie schon ein Smartphone besitzen, " +
						"haben sie wahrscheinlich schon Apps gekauft?<br/>" +
						"Soll das neue Ger�t mit der gleichen Software laufen, damit Sie ihre Anwendungen weiterverwenden k�nnen?</html>";
				progress++;
			} else {
				falseQuestion();
			}
			break;
		case 6:
			if (answer.equals("Ja, das w�re gut. Ich habe derzeit ein Android-Telefon.")) {
				sql = sql + " and OS LIKE '%android%'";
				newQuestion = "M�chten Sie das Smartphone auch als Navigationsger�t nutzen";
				progress++;
			} else {
				falseQuestion();
			}
			break;
		case 7:
			if (answer.equals("Nat�rlich.")) {
				sql = sql + " and GPS = '1'";
				newQuestion = "Bevorzugen Sie einen bestimmten Hersteller?";
				progress++;
			} else {
				falseQuestion();
			}
			break;
		case 8:
			if (answer.equals("Samsung soll gut sein, habe ich geh�rt.")) {
				sql = sql + " and Marke = 'Samsung'";
				newQuestion = "Welchen Preisrahmen haben Sie sich vorgestellt?";
				progress++;
			} else {
				falseQuestion();
			}
			break;
		case 9:
			if (answer.equals("max. 500�")) {
				sql = sql + " and Preis <= '500'";
				newQuestion = "Welchen Preisrahmen haben Sie sich vorgestellt?";
				progress++;
			} else {
				falseQuestion();
			}
			break;
		}
	}

	@Override
	public int maxProgress() {
		return 10;
	}
	
}
