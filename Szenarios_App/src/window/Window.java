package window;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.WindowConstants;

import szenario.Szenario;
import szenario.Szenario1;
import szenario.Szenario2;



public class Window extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = -5419118336515132437L;
	private Szenario selectedSzenario;
    private JButton answerButton;
    private JLabel questionLabel;
    private JMenu menu;
    private JMenuBar menuBar;
    private JScrollPane scrollPane;
    private JTable table;
    private JTextField textField;
    
	public Window() {
		init();
	}
	
	public void setSzenarios(ArrayList<Szenario> szenarios) {
        for (final Szenario szenario : szenarios) {
        	JMenuItem mItem = new JMenuItem(szenario.toString());
        	mItem.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent arg0) {
					if (selectedSzenario != null) {
						selectedSzenario.finish();
					}
					selectedSzenario = szenario;
					selectedSzenario.start();
				}
			});
        	menu.add(mItem);
        }
	}
	
	private void init() {
		GridBagConstraints gridBagConstraints;

        scrollPane = new JScrollPane();
        table = new JTable();
        questionLabel = new JLabel();
        textField = new JTextField();
        answerButton = new JButton();
        menuBar = new JMenuBar();
        menu = new JMenu();

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new GridBagLayout());
        setLocationRelativeTo(null);
        setSize(new Dimension(800, 600));
        answerButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if (selectedSzenario != null)
					selectedSzenario.giveAnswer(textField.getText());
			}
		});

        
        scrollPane.setViewportView(table);

        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = GridBagConstraints.BOTH;
        getContentPane().add(scrollPane, gridBagConstraints);

        
        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.insets = new Insets(0, 8, 0, 8);
        getContentPane().add(questionLabel, gridBagConstraints);

        
        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.weightx = 0.5;
        gridBagConstraints.fill = GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new Insets(0, 12, 0, 12);
        getContentPane().add(textField, gridBagConstraints);

        
        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.fill = GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = GridBagConstraints.LINE_END;
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.weightx = 0.5;
        gridBagConstraints.anchor = GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new Insets(0, 12, 0, 12);
        getContentPane().add(answerButton, gridBagConstraints);

        reset();
        menu.setText("Szenarios");

        menuBar.add(menu);

        setJMenuBar(menuBar);
        
	}

	public void printQuestion(String question) {
		questionLabel.setText(question);
	}
	
	public void printResults(ArrayList<ArrayList<Object>> rows, ArrayList<String> columnNames) {
        this.table.setModel(new MyTableModel(rows, columnNames));
	}
	
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			
			@Override
			public void run() {
				Window w = new Window();
				ArrayList<Szenario> szenarios = new ArrayList<Szenario>();
				szenarios.add(new Szenario1(w));
				szenarios.add(new Szenario2(w));
				w.setSzenarios(szenarios);
				w.setVisible(true);
			}
		});
	}

	public void reset() {
		questionLabel.setText("Frage");
		textField.setText("");
		answerButton.setText("antworten");
		if (table.getModel() instanceof MyTableModel)
			((MyTableModel)table.getModel()).clear();
		selectedSzenario = null;
	}
}
