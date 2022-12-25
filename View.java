import javax.swing.*;
import java.awt.*;
import javax.swing.border.TitledBorder;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import javax.swing.border.EmptyBorder;

// Clase que representa la vista
class View extends JFrame {
  private Model model;
  public JCheckBox[] checkboxes;
  private JButton startButton;
  private JTextArea textArea;

  public View(Model model) {
    this.model = model;
	setDefaultCloseOperation(EXIT_ON_CLOSE);

    setLayout(new FlowLayout());
    setSize(600, 425);
    setTitle("Rise of Kingdoms - Ranking Scanner");
	
	JPanel panel = new JPanel();
    panel.setLayout(new BorderLayout());
	panel.setBorder(new EmptyBorder(10, 0, 0, 0));
	
	JPanel checkboxContainer = new JPanel();
	checkboxContainer.setLayout(new BoxLayout(checkboxContainer, BoxLayout.X_AXIS)); 
	
	// Create a panel for the checkboxes with a GridLayout
    JPanel checkboxPanel1 = new JPanel();
	checkboxPanel1.setLayout(new BoxLayout(checkboxPanel1, BoxLayout.Y_AXIS));
	checkboxPanel1.setBorder(new EmptyBorder(10, 10, 10, 40));
	
	String checkBoxValues[] = {"Highest power","Victory","Defeat","Dead","Scout times","Gathered rss","Sent rss","Help times"};
	checkboxes = new JCheckBox[8];
    for (int i = 0; i < checkboxes.length; i++) {
      checkboxes[i] = new JCheckBox(checkBoxValues[i]);
      checkboxPanel1.add(checkboxes[i]);
    }

	checkboxContainer.add(checkboxPanel1);
	
	JPanel buttonPanel = new JPanel();
	buttonPanel.setLayout(new BoxLayout(buttonPanel, BoxLayout.Y_AXIS));

	startButton = new JButton("Start");
	startButton.setPreferredSize(new Dimension(100, 25));
    // Add the button to the new panel
    buttonPanel.add(startButton);
	panel.add(buttonPanel, BorderLayout.SOUTH);

    // Add the new panel to the left side of the main panel
    panel.add(checkboxContainer, BorderLayout.WEST);
	
	textArea = new JTextArea();
	textArea.setFont(new Font("Monospaced", Font.PLAIN, 12));
	textArea.setForeground(Color.WHITE);
	textArea.setBackground(Color.BLACK);
	textArea.setEditable(false);
	textArea.setPreferredSize(new Dimension(300, 330));
	textArea.setLineWrap(true);
	textArea.setWrapStyleWord(true);
	
	textArea.append("This is some text\n");
	
	// Set the font and color of the title
	TitledBorder border = new TitledBorder("CONSOLE");
	border.setTitleFont(new Font("Monospaced", Font.BOLD, 14));
	border.setTitleColor(Color.BLUE);
	
	// Set the border of the text area to the titled border
	textArea.setBorder(border);

	// Add the console to the right side of the main panel
    panel.add(textArea, BorderLayout.EAST);
	
	add(panel);
  }

  public void updateFromModel() {
    boolean[] selected = model.getSelected();
    for (int i = 0; i < checkboxes.length; i++) {
      checkboxes[i].setSelected(selected[i]);
    }
  }

  public void addStartButtonListener(ActionListener listener) {
    startButton.addActionListener(listener);
  }

  public void addCheckboxListener(ItemListener listener) {
    for (JCheckBox checkbox : checkboxes) {
      checkbox.addItemListener(listener);
    }
  }
}