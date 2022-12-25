import javax.swing.*;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.Arrays;

// Clase que representa el controlador
class Controller implements ActionListener, ItemListener {
  private Model model;
  private View view;
  private boolean[] selected;
  public Controller(Model model, View view) {
    this.model = model;
    this.view = view;

    // Añade los listeners para las acciones del usuario
    view.addStartButtonListener(this);
    view.addCheckboxListener(this);
  }

	// Método que se ejecuta cuando el usuario hace clic en el botón "Iniciar"
	@Override
	public void actionPerformed(ActionEvent e) {
	// Aquí se podría implementar la lógica del programa que se ejecuta al hacer clic en el botón
	selected = model.getSelected();
	System.out.println(Arrays.toString(selected));
	}
	
	// Método que se ejecuta cuando el usuario selecciona o deselecciona un checkbox
	@Override
	public void itemStateChanged(ItemEvent e) {
	// Recorre todos los checkboxes para ver cuál ha cambiado su estado
	for (int i = 0; i < 8; i++) {
		if (e.getSource() == view.checkboxes[i]) {
		// Actualiza el modelo con el nuevo estado del checkbox
		model.setSelected(i, view.checkboxes[i].isSelected());
		}
	}
	}
}