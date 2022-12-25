class main {
  public static void main(String[] args) {
    // Crea una instancia del modelo, la vista y el controlador
    Model model = new Model();
    View view = new View(model);
    Controller controller = new Controller(model, view);

    // Muestra la interfaz gráfica al usuario
    view.setVisible(true);
  }
}