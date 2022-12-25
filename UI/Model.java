import javax.swing.*;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

// Clase que representa el modelo de datos
class Model {
  // Array de booleans que indica qué checkboxes están seleccionados
  private boolean[] selected;

  public Model() {
    // Inicialmente, ningún checkbox está seleccionado
    selected = new boolean[8];
  }

  public boolean[] getSelected() {
    return selected;
  }

  public void setSelected(int index, boolean value) {
    selected[index] = value;
  }
}






