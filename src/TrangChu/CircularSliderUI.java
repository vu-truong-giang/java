package TrangChu;
import javax.swing.JSlider;
import javax.swing.plaf.basic.BasicSliderUI;
import java.awt.*;

public class CircularSliderUI extends BasicSliderUI {

    public CircularSliderUI(JSlider b) {
        super(b);
    }

    @Override
    public void paintThumb(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        Rectangle thumbBounds = thumbRect;

        int diameter = thumbBounds.width;
        int x = thumbBounds.x;
        int y = thumbBounds.y;

        // Draw a circle for the thumb
        g2d.setColor(Color.WHITE);
        g2d.fillOval(x, y, diameter, diameter);

        // Draw the border for the circle
        g2d.setColor(Color.BLACK);
        g2d.drawOval(x, y, diameter, diameter);
    }

    @Override
    protected Dimension getThumbSize() {
        return new Dimension(16, 16); // Size of the circle
    }
}
