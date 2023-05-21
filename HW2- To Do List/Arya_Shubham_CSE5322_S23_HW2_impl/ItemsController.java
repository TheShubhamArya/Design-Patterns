import javax.swing.table.DefaultTableModel;
import java.util.ArrayList;

class ItemsController {
    private ArrayList<Command> history = new ArrayList<>();
    private int commandIndex = -1;
    private DefaultTableModel tableModel;

    public ItemsController(DefaultTableModel tableModel) {
        this.tableModel = tableModel;
    }

    public DefaultTableModel addItem(Item item) {
        Command c = new AddCommand(tableModel, item);
        updateHistory(c);
        commandIndex = history.size()-1;
        add(item);
        return tableModel;
    }

    public DefaultTableModel deleteItem(int index) {
        Command c = new DeleteCommand(tableModel, index);
        updateHistory(c);
        commandIndex = history.size()-1;
        delete(index);
        return tableModel;
    }

    private void updateHistory(Command command) {
        history.add(command);
    }

    private void add(Item item) {
        tableModel.addRow(new Object[]{item.itemID, item.content});
    }

    private void delete(int index){
        tableModel.removeRow(index);
    }

    public DefaultTableModel undo() {
        if (commandIndex >= 0) {
            Command command = history.get(commandIndex);
            DefaultTableModel model = command.undo();
            commandIndex -= 1;
            return model;
        }
        return tableModel;
    }

    public DefaultTableModel redo() {
        if (commandIndex < history.size()-1) {
            commandIndex += 1;
            Command command = history.get(commandIndex);
            DefaultTableModel model = command.redo();
            return model;
        }
        return tableModel;
    }
}
