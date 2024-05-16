package ran;

import java.awt.*;

import java.awt.event.*;
import java.io.*;
import javax.swing.*;

import Sound.PlayMusic;
import dao.BangNguoiChoiDAO;
import dao.BangNguoiDungDAO;
import dao.BangTrangThaiGameDAO;

public class snakeGame extends JFrame implements ActionListener, KeyListener {
	boolean loss = false;
	int BOM, dem = 0;
	int maxXY = 100;
	int m = 25, n = 25;
	int start = 0;
	Color background_cl[] = {Color.gray, Color.LIGHT_GRAY, Color.red, Color.green , Color.YELLOW};
	int convertX[] = {-1, 0, 1, 0};
	int convertY[] = {0, 1, 0, -1};
	int speed[] = {500,400,300,200,100};
	private JButton bt[][] = new JButton[maxXY][maxXY];
	private JComboBox lv = new JComboBox();
	private int a[][] = new int[100][100];
	private int xSnake[] = new int[maxXY * maxXY];
	private int ySnake[] = new int[maxXY * maxXY];
	private int xFood, yFood;
	private int sizeSnake = 0;
	private int direction = 2;
	private JButton newGame_bt, score_bt;
	private int initialSpeed;
	private int currentSpedd;
	
	private Obstacle obstacleManager;
	
	private int[][] map = new int[100][100];
	private static String playerName;

    public static void setPlayerName(String name) {
        playerName = name;
    }

	private JPanel pn, pn2;
	Container cn;
	Timer timer;
	public snakeGame(String s, int k) {
		super(s);
		initialSpeed = speed[k];
		currentSpedd =initialSpeed;
		obstacleManager = new Obstacle(a);
		cn = init(k);
		timer = new Timer(speed[k], new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				runSnake(direction);
			}
		});
	}
	public Container init(int k) {
		//giao diện chính
		Container cn = this.getContentPane();
		pn = new JPanel();
		pn.setLayout(new GridLayout(m,n));
		for (int i = 0; i < m; i++)
			for (int j = 0; j < n; j++){
				bt[i][j] = new JButton();
				pn.add(bt[i][j]);
				bt[i][j].setActionCommand(i + " " + j);
				bt[i][j].addActionListener(this);
				bt[i][j].addKeyListener(this);
				bt[i][j].setBorder(null);
				a[i][j] = 0;
			}
		
		
        obstacleManager.createObstacle(BangTrangThaiGameDAO.getInstance().getValueMap(BangNguoiChoiDAO.getInstance().selectByNameReturnNameuser(playerName)));
		
		pn2 = new JPanel();
		pn2.setLayout(new FlowLayout());
		// bắt đầu
		newGame_bt = new JButton("New Game");
		newGame_bt.addActionListener(this);
		newGame_bt.addKeyListener(this);
		newGame_bt.setFont(new Font("UTM Micra", 1, 15));
		newGame_bt.setBackground(Color.white);
		//điểm: khởi đầu là 3
		score_bt = new JButton("0");
		score_bt.addActionListener(this);
		score_bt.addKeyListener(this);
		score_bt.setFont(new Font("UTM Micra", 1, 15));
		score_bt.setBackground(Color.white);
		// độ khó
		for (int i = 1; i <= speed.length; i++)
		lv.addItem("Level " + i);
		lv.setSelectedIndex(k);
		lv.addKeyListener(this);
		lv.setFont(new Font("UTM Micra", 1, 15));
		lv.setBackground(Color.white);
		// tuỳ chọn
		
		pn2.add(newGame_bt);
		pn2.add(lv);
		pn2.add(score_bt);
		
		a[m / 2][n / 2 - 1] = 1;
		a[m / 2][n / 2] = 1;
		a[m / 2][n / 2 + 1] = 2;
		xSnake[0] = m / 2;
		ySnake[0] = n / 2 - 1;
		xSnake[1] = m / 2;
		ySnake[1] = n / 2;
		xSnake[2] = m / 2;
		ySnake[2] = n / 2 + 1;
		sizeSnake = 3;
		
		creatFood();
		updateColor();
		cn.add(pn);
		cn.add(pn2, "South");
		this.setVisible(true);
		this.setSize(n * 30, m * 30);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		return cn;
	}
	
	
	public void updateColor() {
		for (int i = 0; i < m; i++)
			for (int j = 0; j < n; j++)
				if(map[i][j] == 4) {
					bt[i][j].setBackground(background_cl[a[i][j]]);
				} else {
					bt[i][j].setBackground(background_cl[a[i][j]]);
				}
	}
	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
	}
	// di chuyển
	public void runSnake(int k) {
		a[xSnake[sizeSnake - 1]][ySnake[sizeSnake - 1]] = 1;
		xSnake[sizeSnake] = xSnake[sizeSnake - 1] + convertX[k - 1];
		ySnake[sizeSnake] = ySnake[sizeSnake - 1] + convertY[k - 1];
		
		if (xSnake[sizeSnake] < 0)
			xSnake[sizeSnake] = m - 1;
		if (xSnake[sizeSnake] == m)
			xSnake[sizeSnake] = 0;
		if (ySnake[sizeSnake] < 0)
			ySnake[sizeSnake] = n - 1;
		if (ySnake[sizeSnake] == n)
			ySnake[sizeSnake] = 0;
		
		if (a[xSnake[sizeSnake]][ySnake[sizeSnake]] == 1 || a[xSnake[sizeSnake]][ySnake[sizeSnake]] == 4) {
			timer.stop();
			PlayMusic.SoundSnakeLoss();

			
			int num = Integer.parseInt(score_bt.getText());
			 BangNguoiChoiDAO.getInstance().updateScoreToDatabase(playerName, num);
			int option = JOptionPane.showOptionDialog(null, "Game Over. Điểm của bạn: " + num,
			        "Thông báo", JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE, null,
			        new String[]{"Chơi lại", "Quay trở về"}, // Labels của nút
			        "Chơi lại");
             BangNguoiChoiDAO.getInstance().updateScoreToDatabase(BangNguoiChoiDAO.getInstance().selectByNameReturnNameuser(playerName), num);
             System.out.println(num);
             System.out.println(playerName);
             if (option == JOptionPane.YES_OPTION) {
			        new snakeGame("CodeLearn.io - Game Rắn Săn Mồi", lv.getSelectedIndex());
			        dispose(); // Đóng cửa sổ trò chơi hiện tại
			    } else if (option == JOptionPane.NO_OPTION) {
			    	dispose();
			    }			
			loss = true;
			return;
		}
		a[xSnake[start]][ySnake[start]] = 0;
		if (xFood == xSnake[sizeSnake] && yFood == ySnake[sizeSnake]) {
			a[xSnake[start]][ySnake[start]] = 1;
			start--;
			creatFood();
			PlayMusic.SoundSnakeEatFood();
			score_bt.setText(String.valueOf(Integer.parseInt(score_bt.getText()) + 1));
		}
		a[xSnake[sizeSnake]][ySnake[sizeSnake]] = 2;
		start++;
		sizeSnake++;
		updateColor();
		for (int i = start; i < sizeSnake; i++) {
			xSnake[i - start] = xSnake[i];
			ySnake[i - start] = ySnake[i];
		}
		sizeSnake -= start;
		start = 0;
	}
	// ăn
	public void creatFood() {
		int k = 0;
		for (int i = 0; i < m; i++)
			for (int j = 0; j < n; j++)
				if (a[i][j] == 0)
					k++;
		int h = (int) ((k - 1) *  Math.random() + 1);
		k = 0;
		for (int i = 0; i < m; i++)
			for (int j = 0; j < n; j++)
				if (a[i][j] == 0) {
					k++;
					if (k == h) {
						xFood = i;
						yFood = j;
						a[i][j] = 3;
						return;
					}
				}
	}
	

	private void updateScore(int num , int delay) {
		if(num % 10 ==0 ) {
			delay-= 10;
			timer.setDelay(delay);
		}
	}
	
	@Override
	public void keyPressed(KeyEvent e) {
		if (!loss) {
			// TODO Auto-generated method stub
			if (e.getKeyCode() == KeyEvent.VK_UP && direction != 3) {
			    direction = 1;
			    timer.start();
			    
			}

			if (e.getKeyCode() == e.VK_RIGHT && direction != 4) {
				direction = 2;
				timer.start();
				
			}
			if (e.getKeyCode() == e.VK_DOWN && direction != 1) {
				direction = 3;
				timer.start();
			
			}
			if (e.getKeyCode() == e.VK_LEFT && direction != 2) {
				direction = 4;
				timer.start();
				
			}
		}
	}
	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (e.getActionCommand() == newGame_bt.getText()) {
			new snakeGame("CodeLearn.io - Game Rắn Săn Mồi", lv.getSelectedIndex());
			this.dispose();
		}
		
	}
	
	
	public static void main(String[] args) {
		new snakeGame("CodeLearn.io - Game Rắn Săn Mồi", 4);
	}
}

