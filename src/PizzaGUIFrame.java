import javax.swing.*;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;
import java.awt.*;

public class PizzaGUIFrame extends JFrame {

    JPanel mainPnl;
    JPanel crustPnl;
    JPanel sizePnl;
    JPanel toppingsPnl;
    JPanel orderPnl;
    JPanel controlPnl;

    JRadioButton thinCrustRB;
    JRadioButton regCrustRB;
    JRadioButton deepDishCrustRB;

    JComboBox pizzaSizeCB;

    JCheckBox sourWormsCB;
    JCheckBox butterBeerCB;
    JCheckBox skittlesCB;
    JCheckBox zombieBrainsCB;
    JCheckBox monsterGutsCB;
    JCheckBox spidersCB;

    JTextArea orderTA;
    JScrollPane scroll;

    JButton quitBtn;
    JButton clearBtn;
    JButton dispalyOrderBtn;

    JOptionPane quitPane;

    ButtonGroup buttonGroup;

    public PizzaGUIFrame() {
        createCenterFrame();
        setLayout(new BorderLayout());

        mainPnl = new JPanel();
        mainPnl.setLayout(new GridBagLayout());


        GridBagConstraints grid = new GridBagConstraints();

        grid.gridx = 0;
        grid.gridy = 1;
        createCrustPanel();
        mainPnl.add(crustPnl, grid);

        grid.gridx = 1;
        grid.gridy = 1;
        createSizePanel();
        mainPnl.add(sizePnl);

        grid.gridx = 2;
        grid.gridy = 1;
        createToppingsPanel();
        mainPnl.add(toppingsPnl, grid);

        grid.gridx = 0;
        grid.gridy = 0;
        createOrderPanel();
        mainPnl.add(orderPnl, grid);

        grid.gridx = 1;
        grid.gridy = 0;
        createControlPanel();
        mainPnl.add(controlPnl, grid);

        add(mainPnl, BorderLayout.CENTER);
        setTitle("Pizza Order");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    private void createCrustPanel() {
        crustPnl = new JPanel();
        crustPnl.setBorder(new TitledBorder(new EtchedBorder(), "Crust"));

        thinCrustRB = new JRadioButton("Thin Crust");
        regCrustRB = new JRadioButton("Regular Crust");
        deepDishCrustRB = new JRadioButton("Deep Dish Crust");

        buttonGroup = new ButtonGroup();
        buttonGroup.add(thinCrustRB);
        buttonGroup.add(regCrustRB);
        buttonGroup.add(deepDishCrustRB);

        thinCrustRB.setSelected(false);
        regCrustRB.setSelected(false);
        deepDishCrustRB.setSelected(false);

        crustPnl.add(thinCrustRB);
        crustPnl.add(regCrustRB);
        crustPnl.add(deepDishCrustRB);
    }

    private void createSizePanel() {
        sizePnl = new JPanel();
        sizePnl.setBorder(new TitledBorder(new EtchedBorder(), "Pizza Size"));

        pizzaSizeCB = new JComboBox();
        pizzaSizeCB.addItem("Small");
        pizzaSizeCB.addItem("Medium");
        pizzaSizeCB.addItem("Large");
        pizzaSizeCB.addItem("Super");

        sizePnl.add(pizzaSizeCB);
    }

    private void createToppingsPanel() {

    }

    private void createOrderPanel() {

    }

    private void createControlPanel() {

    }

    private void getOrder() {

    }

    private void createCenterFrame(){
        //screen dimensions
        Toolkit toolkit = Toolkit.getDefaultToolkit();
        Dimension screenSize = toolkit.getScreenSize();
        int screenWidth = screenSize.width;
        int screenHeight = screenSize.height;
        //center frame
        setSize(screenWidth * 3 / 4, screenHeight * 3 / 4);
        setLocation(screenWidth / 8, screenHeight / 8);
    }
}
