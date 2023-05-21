import javax.swing.table.DefaultTableModel;

interface Command {
    DefaultTableModel execute();
    DefaultTableModel undo();
    DefaultTableModel redo();
}