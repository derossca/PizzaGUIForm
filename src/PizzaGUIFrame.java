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
        mainPnl.setLayout(new BorderLayout());



        createCrustPanel();
        mainPnl.add(crustPnl, BorderLayout.NORTH);

        createSizePanel();
        mainPnl.add(sizePnl, BorderLayout.EAST);

        createToppingsPanel();
        mainPnl.add(toppingsPnl, BorderLayout.WEST);

        createOrderPanel();
        mainPnl.add(orderPnl, BorderLayout.CENTER);

        createControlPanel();
        mainPnl.add(controlPnl, BorderLayout.SOUTH);

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
        toppingsPnl.setLayout(new BoxLayout(toppingsPnl, BoxLayout.Y_AXIS));

        sourWormsCB = new JCheckBox("Sour Worms");
        butterBeerCB = new JCheckBox("Butterbeer");
        skittlesCB = new JCheckBox("Skittles");
        zombieBrainsCB = new JCheckBox("Zombie Brains");
        monsterGutsCB = new JCheckBox("Monster Guts");
        spidersCB = new JCheckBox("Spiders");

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
        displayOrderBtn.setFont(new Font("Arial", Font.BOLD, 22));
        displayOrderBtn.addActionListener(e -> {
            getOrder();
        });

        clearBtn = new JButton("Clear");
        clearBtn.setFont(new Font("Arial", Font.BOLD, 22));
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
        quitBtn.setFont(new Font("Arial", Font.BOLD, 22));
        quitBtn.addActionListener(e -> {
            quitPane = new JOptionPane();
            int quit = JOptionPane.showConfirmDialog(null, "Do you want to quit?", "Quit", JOptionPane.YES_NO_OPTION);
            if (quit == JOptionPane.YES_OPTION) {
                System.exit(0);
            }
        });

        controlPnl.add(displayOrderBtn);
        controlPnl.add(clearBtn);
        controlPnl.add(quitBtn);
    }

    private void getOrder(){
        String res = "Order Details\n";
        String getSize = "";
        double sizePrice = 0.0;
        double toppingPrice = 0.0;

        res += "==================================================\n";

        res += "Crust: ";
        if (thinCrustRB.isSelected()) {
            res += "\tThin\n";
        } else if (regCrustRB.isSelected()) {
            res += "\tRegular\n";
        } else {
            res += "\tDeepdish\n";
        }


        res += "Size: \t";
        getSize = (String) pizzaSizeCB.getSelectedItem();
        res += getSize + "\n";
        sizePrice = switch (getSize) {
          case "Small" -> 8.00;
          case "Medium" -> 12.00;
          case "Large" -> 16.00;
          case "Super" -> 20.00;
          default -> 0;
        };
        res += "\t\t" + sizePrice + "\n";

        res += "Toppings:\n";
        if(sourWormsCB.isSelected()){
            toppingPrice += 1.00;
            res += "\tSour Worms\t" + 1.00 + "\n";
        }

        if (butterBeerCB.isSelected()){
            toppingPrice += 1.00;
            res += "\tButterbeer\t" + 1.00 + "\n";
        }

        if (skittlesCB.isSelected()){
            toppingPrice += 1.00;
            res += "\tSkittles\t" + 1.00 + "\n";
        }

        if (zombieBrainsCB.isSelected()){
            toppingPrice += 1.00;
            res += "\tZombie Brains\t" + 1.00 + "\n";

        }

        if (monsterGutsCB.isSelected()){
            toppingPrice += 1.00;
            res += "\tMonster Guts\t" + 1.00 + "\n";

        }

        if (spidersCB.isSelected()){
            toppingPrice += 1.00;
            res += "\tSpiders\t" + 1.00 + "\n";

        }

        double subTotal = sizePrice + toppingPrice;
        String subTotalString = String.format("%.2f", subTotal);
        double tax = subTotal * .07;
        String taxString = String.format("%.2f", tax);
        double total = subTotal + tax;
        String totalString = String.format("%.2f", total);

        res += "\n";
        res += "Sub-total: \t\t" + subTotalString + "\n";
        res += "Tax: \t\t" + taxString + "\n";
        res += "--------------------------------------------------\n";
        res += "Total: \t\t" + totalString;
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
