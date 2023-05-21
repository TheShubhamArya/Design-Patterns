import javax.swing.table.DefaultTableModel;

class DeleteCommand implements Command {
    
    private DefaultTableModel tableModel;
    private int index = -10;
    private Item item;

    public DeleteCommand(DefaultTableModel tableModel, int index) {
        this.tableModel = tableModel;
        String itemID = (String) tableModel.getValueAt(index, 0);
        String content = (String) tableModel.getValueAt(index, 1);
        item = new Item(itemID, content);
        this.index = index;
    }

    public DefaultTableModel execute() {
        tableModel.removeRow(index);
        return tableModel;
    }

    public DefaultTableModel undo() {
        tableModel.insertRow(index, new Object[]{item.itemID, item.content});
        return tableModel;
    }

    public DefaultTableModel redo() {
        tableModel.removeRow(index);
        return tableModel;
    }
}
