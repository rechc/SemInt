package szenario;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import sql.DBConnector;
import window.Window;

public abstract class Szenario {
	protected int progress;
	protected String sql;
	protected String newQuestion = "";
	
	protected Window w;
	
	public Szenario(Window w) {
		this.w = w;
	}
	
	public void finish() {
		JOptionPane.showMessageDialog(w, "Szenario ist fertig bei Frage " + progress);
		progress = 0;
		sql = null;
		w.reset();
	}

	protected void falseQuestion() {
		JOptionPane.showMessageDialog(w, "Falsche Frage für Frage Nummer " + progress);
	}
	
	public void giveAnswer(String answer) {
		try {
			ArrayList<ArrayList<Object>> rows = new ArrayList<ArrayList<Object>>();
			cases(answer);
			if (sql != null) {
				PreparedStatement ps = DBConnector.getInstance().con.prepareStatement(sql);
				ResultSet rs = ps.executeQuery();
				int columnCount = rs.getMetaData().getColumnCount();
				ArrayList<String> columnNames = new ArrayList<String>();
				for (int i = 1; i <= columnCount; i++) {
					columnNames.add(rs.getMetaData().getColumnName(i));
				}
				while (rs.next()) {
					ArrayList<Object> values = new ArrayList<Object>();
					for (int i = 1; i <= columnCount; i++)
						values.add(rs.getObject(i));
					rows.add(values);
				}
				w.printResults(rows, columnNames);
				if (rows.size() <= 1) {
					finish();
					return;
				}
			}
			if (progress == maxProgress()) {
				finish();
			} else {
				w.printQuestion(newQuestion);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBConnector.getInstance().disconnect();
		}
	}
	
	public abstract void cases(String answer);
	public abstract void start();
	public abstract int maxProgress();
}
