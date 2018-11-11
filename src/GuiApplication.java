import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GuiApplication {
    private JTextField NameField;
    private JPanel InputOutputPanel;
    private JPanel ButtonsPanel;
    private JTextField SurnameField;
    private JTextField AgeField;
    private JLabel NameLabel;
    private JLabel SurnameLabel;
    private JLabel AgeLabel;
    private JButton NextButton;
    private JButton SaveButton;
    private JButton SortButton;
    private JButton UpButton;
    private JButton DownButton;
    private JPanel MainPanel;
    private Data data;

    public GuiApplication() {
        JFrame frame = new JFrame("Homework");
        frame.setContentPane(getMainPanel());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);

        this.data = new Data();
        displayCurrentPerson();

        NextButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent event) {

                Person person = new Person(NameField.getText(), SurnameField.getText(),Integer.parseInt(AgeField.getText()));
                data.addNewPerson(person);
            }
        });
        SaveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                data.savePeopleList();
            }
        });
        SortButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                data.sortPeopleBySurname();
            }
        });
        UpButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                data.nextPerson();
                displayCurrentPerson();
            }
        });
        DownButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                data.previousPerson();
                displayCurrentPerson();
            }
        });
    }

    JPanel getMainPanel() {
        return MainPanel;
    }
    private void displayCurrentPerson()
    {
        NameField.setText(data.getCurrent().getName());
        SurnameField.setText(data.getCurrent().getSurname());
        AgeField.setText(Integer.toString(data.getCurrent().getAge()));
    }
}
