import javax.swing.*;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.event.ActionListener;

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
    JButton displayOrderBtn;

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
        toppingsPnl = new JPanel();
        toppingsPnl.setBorder(new TitledBorder(new EtchedBorder(), "Toppings"));

        sourWormsCB = new JCheckBox();
        butterBeerCB = new JCheckBox();
        skittlesCB = new JCheckBox();
        zombieBrainsCB = new JCheckBox();
        monsterGutsCB = new JCheckBox();
        spidersCB = new JCheckBox();

        toppingsPnl.add(sourWormsCB);
        toppingsPnl.add(butterBeerCB);
        toppingsPnl.add(skittlesCB);
        toppingsPnl.add(zombieBrainsCB);
        toppingsPnl.add(monsterGutsCB);
        toppingsPnl.add(spidersCB);
    }

    private void createOrderPanel() {
        orderPnl = new JPanel();
        orderPnl.setBorder(new TitledBorder(new EtchedBorder(), "Order"));

        orderTA = new JTextArea();

        orderPnl.add(orderTA);
    }

    private void createControlPanel() {
        controlPnl = new JPanel();
        controlPnl.setBorder(new TitledBorder(new EtchedBorder(), "Controls"));

        displayOrderBtn = new JButton("Display Order");
        displayOrderBtn.addActionListener(e -> {
            getOrder();
        });

        clearBtn = new JButton("Clear");
        clearBtn.addActionListener(e -> {
            orderTA.setText("");
            thinCrustRB.setSelected(false);
            regCrustRB.setSelected(false);
            deepDishCrustRB.setSelected(false);
            sourWormsCB.setSelected(false);
            butterBeerCB.setSelected(false);
            skittlesCB.setSelected(false);
            zombieBrainsCB.setSelected(false);
            monsterGutsCB.setSelected(false);
            spidersCB.setSelected(false);
        });

        quitBtn = new JButton("Quit");
        quitBtn.addActionListener(e -> {
            quitPane = new JOptionPane();

        });
    }

    private void getOrder(){
        String res = "Order Details\n";
        String getSize = "";
        double sizePrice;
        double toppingPrice = 0.0;
        double subTotal = sizePrice + toppingPrice;
        double tax = subTotal * .07;
        double total = subTotal + tax;

        res += "Crust: ";
        if (thinCrustRB.isSelected()) {
            res += "Thin\n";
        } else if (regCrustRB.isSelected()) {
            res += "Regular\n";
        } else {
            res += "Deepdish\n";
        }

        res += "==================================================\n";

        res += "Size: ";
        getSize = (String) pizzaSizeCB.getSelectedItem();
        res += getSize + "\n"
        sizePrice = switch (getSize) {
          case "Small" -> 8.00;
          case "Medium" -> 12.00;
          case "Large" -> 16.00;
          case "Super" -> 20.00;
          default -> 0;
        };
        res += sizePrice + "\n";

        res += "Toppings:\n";
        if(sourWormsCB.isSelected()){
            res += "\tSour\n";
            toppingPrice = 1.00;
        }

        if (butterBeerCB.isSelected()){
            res += "\tButterbeer\n";
            toppingPrice = 1.00;
        }

        if (skittlesCB.isSelected()){
            res += "\tSkittles\n";
            toppingPrice = 1.00;
        }

        if (zombieBrainsCB.isSelected()){
            res += "\tZombie\n";
            toppingPrice = 1.00;
        }

        if (monsterGutsCB.isSelected()){
            res += "\tMonster\n";
            toppingPrice = 1.00;
        }

        if (spidersCB.isSelected()){
            res += "\tSpiders\n";
            toppingPrice = 1.00;
        }

        res += "Sub-total: " + subTotal + "\n";
        res += "Tax: " + tax + "\n";
        res += "--------------------------------------------------\n";
        res += "Total:" + total;
        res += "\n";
        res += "==================================================\n";

        orderTA.setText(res);
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
