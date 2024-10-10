import javax.swing.*;
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
    JButton dispalyOrderBtn;

    public PizzaGUIFrame() {
        createCenterFrame();
        setTitle("Pizza Order");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        mainPnl = new JPanel();

    }

    private void createCrustPanel() {

    }

    private void createSizePanel() {

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
