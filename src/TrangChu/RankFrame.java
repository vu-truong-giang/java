package TrangChu;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import LogIn.LoginForm;
import dao.BangNguoiChoiDAO;
import dao.BangTrangThaiGameDAO;
import model.rank;

public class RankFrame {
    
    private JPanel rankPanel;
    private static String playerName;

    public static void setPlayerName(String name) {
        playerName = name;
    }

    public static void main(String[] avgr) {
        SwingUtilities.invokeLater(() -> new RankFrame());
    }
    
    public RankFrame() {
        JFrame frame = new JFrame("Rank");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        // Khởi tạo JPanel để chứa thông tin rank, sử dụng GridBagLayout
        rankPanel = new JPanel(new GridBagLayout());

        // Thiết lập các thông số cho GridBagConstraints
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.insets = new Insets(5, 10, 5, 10); 
        gbc.anchor = GridBagConstraints.WEST;

        // Tạo tiêu đề cho các cột
        addComponent(new JLabel("Tên Đăng Nhập"), gbc, rankPanel);
        gbc.gridx++;
        addComponent(new JLabel("Điểm Số"), gbc, rankPanel);
        gbc.gridx++;
        addComponent(new JLabel("Xếp Hạng"), gbc, rankPanel);

        // Lấy danh sách rank từ cơ sở dữ liệu
        ArrayList<rank> ranks = BangNguoiChoiDAO.getInstance().insertTop10();
        
        if (ranks != null) {
            gbc.gridy++; 
            for (rank r : ranks) {
                gbc.gridx = 0; 
                addComponent(new JLabel(r.getName()), gbc, rankPanel);
                gbc.gridx++;
                addComponent(new JLabel(String.valueOf(r.getDiem())), gbc, rankPanel);
                gbc.gridx++;
                addComponent(new JLabel(String.valueOf(r.getXephang())), gbc, rankPanel);
                gbc.gridy++; 
            }
        } else {
            JLabel noDataLabel = new JLabel("Không có dữ liệu.");
            addComponent(noDataLabel, gbc, rankPanel);
        }
        
        frame.add(new JScrollPane(rankPanel), BorderLayout.CENTER);
       
        
     // Tạo JSeparator để vẽ một đường thẳng ngang
        JSeparator separator = new JSeparator(SwingConstants.HORIZONTAL);

        separator.setForeground(Color.BLUE); 
        gbc.gridx = 0;
        gbc.gridy = 12; //
        gbc.gridwidth = 3; 
        addComponent(separator, gbc, rankPanel);

     // Thiết lập các ràng buộc GridBagConstraints cho đường kẻ ngang
  
       rank rankuser = BangNguoiChoiDAO.getInstance().InsertRankUser(BangNguoiChoiDAO.getInstance().selectByNameReturnNameuser(playerName));
       gbc.gridx = 0;
       gbc.gridy = 13;
       // Hiển thị thông tin của mỗi rank
       addComponent(new JLabel(rankuser.getName()), gbc, rankPanel);
       gbc.gridx++;
       addComponent(new JLabel(String.valueOf(rankuser.getDiem())), gbc, rankPanel);
       gbc.gridx++;
       addComponent(new JLabel(String.valueOf(rankuser.getXephang())), gbc, rankPanel);

      
       JButton ok = new JButton("cancel");
       ok.addActionListener(new ActionListener() {
           public void actionPerformed(ActionEvent e) {
               // Đóng cửa sổ hiện tại
               frame.dispose();
           }
       });
       gbc.gridx = 0;
       gbc.gridy = 14;
       addComponent(ok, gbc, rankPanel);


       
       frame.pack();
        frame.setLocationRelativeTo(null); // Hiển thị cửa sổ ở giữa màn hình
        frame.setVisible(true);
    }

    // Phương thức để thêm thành phần vào panel với các ràng buộc GridBagConstraints
    private void addComponent(Component component, GridBagConstraints constraints, JPanel panel) {
        panel.add(component, constraints);
    }
}
