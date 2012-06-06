package szenario;


import window.Window;


public class Szenario1 extends Szenario {
	public Szenario1(Window w) {
		super(w);
	}

	@Override
	public void start() {
		w.printQuestion(newQuestion = "Wofür möchten Sie das Smartphone verwenden?");
	}


	@Override
	public String toString() {
		return "Szenario eins";
	}

	@Override
	public void cases(String answer) {
		switch(progress) {
		case 0:
			if (answer.equals("Telefonieren, SMS, Internet, E-Mail, Spiele")) {
				sql = "select * from Smartphones where wlan = '1'";
				newQuestion = "Wie groß soll das Display des Geräts sein?";
				progress++;
			} else {
				falseQuestion();
			}
			break;
		case 1:
			if (answer.equals("Das es bequem in die Hosentasche passt und gut in der Hand liegt.")) {
				sql = sql + " and displaygroesse between '3.0' and '4.0'";
				newQuestion = "Möchten Sie ein reines Touchdisplay oder eine zusätzliche Hardwaretastatur am Gerät?";
				progress++;
			} else {
				falseQuestion();
			}
			break;
		case 2:
			if (answer.equals("Ein Gerät ohne Hardwaretastatur.")) {
				sql = sql + " and hardwaretastatur = '1'";
				newQuestion = "Nutzen Sie das Gerät eher für geschäftliche Zwecke oder in ihrer Freizeit für Outdooraktivitäten?";
				progress++;
			} else {
				falseQuestion();
			}
			break;
		case 3:
			if (answer.equals("Eher im private Hausgebrauch, teilweise auch beim Sport im freien.")) {
				sql = sql + " and MSExchange = '1' and Material = 'Metall' and outdoor = '1'";
				newQuestion = "Möchten Sie das Smartphone zur Navigation oder zur Aufzeichnung ihrer sportlichen Aktivitäten verwenden?";
				progress++;
			} else {
				falseQuestion();
			}
			break;
		case 4:
			if (answer.equals("Ja, möchte ich.")) {
				sql = sql + " and GPS = '1' and Akkulaufzeit between 24 and 50";
				newQuestion = "Nutzen Sie das Smartphone auch als Digitalkameraersatz?";
				progress++;
			} else {
				falseQuestion();
			}
			break;
		case 5:
			if (answer.equals("Ja, ich mache viele Bilder mit dem Gerät.")) {
				sql = sql + " and `Interner Speicher` >= '10000' and Kameraaufloesung >= '5'";
				newQuestion = "Für welche Spiele nutzen Sie das Gerät?";
				progress++;
			} else {
				falseQuestion();
			}
			break;
		case 6:
			if (answer.equals("Nur klein Spiele, wie Sudoku oder Tetris zum Zeitvertreib.")) {
				sql = sql + " and MHz <= 1000 and cores = '1'";
				newQuestion = "Bevorzugen Sie eine bestimmte Marke?";
				progress++;
			} else {
				falseQuestion();
			}
			break;
		case 7:
			if (!answer.equals("Nein, die Marke ist mir egal.")) {
				falseQuestion();
			} else {
				progress++;
			}
		}
	}

	@Override
	public int maxProgress() {
		return 8;
	}
}
