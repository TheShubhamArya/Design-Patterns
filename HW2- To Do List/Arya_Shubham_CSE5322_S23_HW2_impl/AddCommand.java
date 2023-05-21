import javax.swing.table.DefaultTableModel;

class AddCommand implements Command {
    private Item item;
    private DefaultTableModel tableModel;
    private int index;

    public AddCommand(DefaultTableModel tableModel, Item item) {
        this.tableModel = tableModel;
        this.item = item;
        this.index = tableModel.getRowCount();
    }

    public DefaultTableModel execute() {
        tableModel.insertRow(index, new Object[]{item.itemID, item.content});
        return tableModel;
    }

    public DefaultTableModel undo() {
        tableModel.removeRow(index);
        return tableModel;
    }

    public DefaultTableModel redo() {
        tableModel.insertRow(index, new Object[]{item.itemID, item.content});
        return tableModel;
    }
}