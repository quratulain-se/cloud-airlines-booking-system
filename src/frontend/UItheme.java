package frontend;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.geom.RoundRectangle2D;

public class UItheme {

    // Gradient background panel (dark navy -> slate blue)
    public static class GradientPanel extends JPanel {
        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            Graphics2D g2 = (Graphics2D) g;
            g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
            GradientPaint gp = new GradientPaint(0, 0, new Color(20, 30, 48),
                    getWidth(), getHeight(), new Color(36, 59, 85));
            g2.setPaint(gp);
            g2.fillRect(0, 0, getWidth(), getHeight());
        }
    }

    // Rounded translucent "glass" card
    public static class RoundedPanel extends JPanel {
        private final int radius;
        private final Color bg;

        public RoundedPanel(int radius, Color bg) {
            this.radius = radius;
            this.bg = bg;
            setOpaque(false);
        }

        @Override
        protected void paintComponent(Graphics g) {
            Graphics2D g2 = (Graphics2D) g.create();
            g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
            g2.setColor(bg);
            g2.fill(new RoundRectangle2D.Float(0, 0, getWidth(), getHeight(), radius, radius));
            g2.dispose();
            super.paintComponent(g);
        }
    }

    // Glowing / transparent button
    public static class GlowButton extends JButton {
        private boolean hover = false;

        public GlowButton(String text) {
            super(text);
            setContentAreaFilled(false);
            setFocusPainted(false);
            setBorderPainted(false);
            setForeground(Color.WHITE);
            setFont(new Font("Arial", Font.BOLD, 16));
            setCursor(new Cursor(Cursor.HAND_CURSOR));
            addMouseListener(new MouseAdapter() {
                @Override
                public void mouseEntered(MouseEvent e) {
                    hover = true;
                    repaint();
                }

                @Override
                public void mouseExited(MouseEvent e) {
                    hover = false;
                    repaint();
                }
            });
        }

        @Override
        protected void paintComponent(Graphics g) {
            Graphics2D g2 = (Graphics2D) g.create();
            g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

            if (hover) {
                for (int i = 8; i > 0; i--) {
                    g2.setColor(new Color(90, 190, 255, 10));
                    g2.fill(new RoundRectangle2D.Float(-i, -i, getWidth() + i * 2, getHeight() + i * 2, 30, 30));
                }
            }

            GradientPaint gp = hover
                    ? new GradientPaint(0, 0, new Color(80, 170, 255, 220), getWidth(), getHeight(), new Color(30, 90, 200, 220))
                    : new GradientPaint(0, 0, new Color(255, 255, 255, 40), getWidth(), getHeight(), new Color(255, 255, 255, 15));
            g2.setPaint(gp);
            g2.fill(new RoundRectangle2D.Float(0, 0, getWidth(), getHeight(), 25, 25));

            g2.setColor(new Color(255, 255, 255, hover ? 200 : 120));
            g2.setStroke(new BasicStroke(1.5f));
            g2.draw(new RoundRectangle2D.Float(0.5f, 0.5f, getWidth() - 1, getHeight() - 1, 25, 25));

            g2.dispose();
            super.paintComponent(g);
        }
    }



    public static void styleField(JTextField field) {
        field.setOpaque(false);
        field.setForeground(Color.WHITE);
        field.setCaretColor(Color.WHITE);
        field.setFont(new Font("Arial", Font.PLAIN, 14));
        field.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createMatteBorder(0, 0, 2, 0, new Color(255, 255, 255, 160)),
                new javax.swing.border.EmptyBorder(5, 5, 5, 5)
        ));
    }

public static class Glowtext extends JLabel{

    public Glowtext(String text) {
        super(text);

        setForeground(Color.WHITE);
        setCursor(new Cursor(Cursor.HAND_CURSOR));

        addMouseListener(new MouseAdapter() {

            @Override
            public void mouseEntered(MouseEvent e) {
                setForeground(new Color(100, 181, 246));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                setForeground(Color.WHITE);
            }
        });
    }
}
}