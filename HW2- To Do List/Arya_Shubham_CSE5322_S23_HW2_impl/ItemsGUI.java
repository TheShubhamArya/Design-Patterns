import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.*;

public class ItemsGUI extends JFrame{

    private JButton addButton, deleteButton, undoButton, redoButton;
    private DefaultTableModel tableModel;
    private JTable table;
    private ItemsController controller;

    public ItemsGUI() {
        int screenSize = 600;
        setTitle("HW2 GUI");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(screenSize, screenSize);
        setMinimumSize(new Dimension(screenSize, screenSize));
        setMaximumSize(new Dimension(screenSize, screenSize));
        setLocationRelativeTo(null);

        tableModel = new DefaultTableModel(new Object[]{"Item ID", "Content"}, 0);
        table = new JTable(tableModel);
        controller = new ItemsController(tableModel);
        JPanel buttonPanel = setupButtonPanel();

        Container container = getContentPane();
        container.setLayout(new BorderLayout());
        container.add(new JScrollPane(table), BorderLayout.CENTER);
        container.add(buttonPanel, BorderLayout.SOUTH);

        setButtonActions();

        setVisible(true);
    }

    private JPanel setupButtonPanel() {
        addButton = new JButton("Add");
        deleteButton = new JButton("Delete");
        undoButton = new JButton("Undo");
        redoButton = new JButton("Redo");

        JPanel buttonPanel = new JPanel(new GridLayout(1, 4));
        buttonPanel.add(addButton);
        buttonPanel.add(deleteButton);
        buttonPanel.add(undoButton);
        buttonPanel.add(redoButton);

        return buttonPanel;
    }

    public void setButtonActions() {
        addButtonItemAction();
        deleteButtonItemAction();
        undoButtonItemAction();
        redoButtonItemAction();
    }

    public void addButtonItemAction() {
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                displayAddDialogBox();
            }
        });
    }

    public void deleteButtonItemAction() {
        deleteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int index_to_delete = table.getSelectedRow();
                tableModel = controller.deleteItem(index_to_delete);
                refreshTable();
            }
        });
    }

    public void undoButtonItemAction() {
        undoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                tableModel = controller.undo();
                refreshTable();
             }
        });
    }

    public void redoButtonItemAction() {
        redoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                tableModel = controller.redo();
                refreshTable();
             }
        });
    }

    public void refreshTable(){
        tableModel.fireTableDataChanged();
    }

    // When add button is clicked, this function is called and a dialog box is displayed to add a new item
    public void displayAddDialogBox(){
        JPanel dialogPanel = new JPanel();
        dialogPanel.setLayout(new BoxLayout(dialogPanel, BoxLayout.Y_AXIS));
        dialogPanel.add(new JLabel("Item ID:"));
        JTextField itemIDTF = new JTextField();
        dialogPanel.add(itemIDTF);
        dialogPanel.add(new JLabel("Content:"));
        JTextField contentTF = new JTextField();
        dialogPanel.add(contentTF);

        int result = JOptionPane.showConfirmDialog(
            null,
            dialogPanel,
             "Add item",
              JOptionPane.OK_CANCEL_OPTION
        );

        if (result == JOptionPane.OK_OPTION) {
            String itemID = itemIDTF.getText();
            String content = contentTF.getText();
            Item item = new Item(itemID, content);
            tableModel = controller.addItem(item);
            refreshTable();
        } else if (result == JOptionPane.CANCEL_OPTION) {
            System.out.println("Cancel option in clicked");
        }
    } 

    public static void main(String[] args) {
        new ItemsGUI();
    }
}

