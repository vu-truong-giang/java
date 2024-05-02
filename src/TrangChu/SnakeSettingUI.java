package TrangChu;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class SnakeSettingUI extends JFrame implements ActionListener {
    private JComboBox<String> mapComboBox;
    private JButton colorButton;
    private Color snakeColor;

    public SnakeSettingUI() {
        setTitle("Snake Settings");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(300, 150);
        setLocationRelativeTo(null);

        // Map selection
        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);

        // Tạo label cho map
        JLabel mapLabel = new JLabel("Map Image");
        gbc.gridx = 1;
        gbc.gridy = 0;
        add(mapLabel, gbc);
        
        JButton leftMapBtn = new JButton("Left");
        leftMapBtn.setIcon(new ImageIcon(Toolkit.getDefaultToolkit().createImage(SnakeSettingUI.class.getResource("Icon_left.png"))));
        gbc.gridx = 0 ;
        gbc.gridy = 0;
        add(leftMapBtn, gbc);
        
        JButton rightMapBtn = new JButton("Right");
        rightMapBtn.setIcon(new ImageIcon(Toolkit.getDefaultToolkit().createImage(SnakeSettingUI.class.getResource("Icon_right.png"))));
        gbc.gridx = 2;
        gbc.gridy = 0;
        add(rightMapBtn, gbc);
        
        // Tạo label cho rắn
        JLabel snakeLabel = new JLabel("Snake Image");
        gbc.gridx = 4;
        gbc.gridy = 0;
        add(snakeLabel, gbc);

        // Tạo đối tượng JComboBox và thêm các mục vào
        mapComboBox = new JComboBox<>();
        mapComboBox.addItem("Map 1");
        mapComboBox.addItem("Map 2");
        gbc.gridx = 0;
        gbc.gridy = 1;
        add(mapComboBox, gbc);

        // Tạo nút chọn màu
        colorButton = new JButton("Choose Color");
        colorButton.addActionListener(this);
        gbc.gridx = 1;
        gbc.gridy = 1;
        add(colorButton, gbc);

        // OK button
        JButton okButton = new JButton("OK");
        okButton.addActionListener(this);
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.gridwidth = 2;
        gbc.anchor = GridBagConstraints.CENTER;
        add(okButton, gbc);

        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == colorButton) {
            // Hiển thị hộp thoại chọn màu và cập nhật snakeColor
            snakeColor = JColorChooser.showDialog(this, "Choose Snake Color", Color.GREEN);
        } else if (e.getActionCommand().equals("OK")) {
            // Xử lý khi người dùng nhấn nút OK
            String selectedMap = (String) mapComboBox.getSelectedItem();
            // Thực hiện các hành động cần thiết với map và màu rắn đã chọn
            System.out.println("Selected Map: " + selectedMap);
            System.out.println("Selected Snake Color: " + snakeColor);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new SnakeSettingUI());
    }
}
