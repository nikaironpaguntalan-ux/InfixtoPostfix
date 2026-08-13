import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class Ui extends JFrame {

    // ============================================================
    // COLORS / DESIGN
    // ============================================================

    private final Color BACKGROUND = new Color(245, 247, 250);
    private final Color WHITE = Color.WHITE;
    private final Color DARK = new Color(40, 55, 75);
    private final Color BLUE = new Color(52, 152, 219);
    private final Color GREEN = new Color(39, 174, 96);
    private final Color RED = new Color(192, 57, 43);
    private final Color GRAY = new Color(120, 130, 140);

    // ============================================================
    // GUI COMPONENTS
    // ============================================================

    private JTextField infixField;

    private JTextArea conversionArea;

    private JTextArea stackOperationsArea;

    private JPanel visualStackPanel;

    private JLabel postfixResultLabel;

    // ============================================================
    // CONSTRUCTOR
    // ============================================================

    public Ui() {

        setTitle("INFIX TO POSTFIX CALCULATOR");

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        setSize(1050, 800);

        setMinimumSize(new Dimension(900, 700));

        setLocationRelativeTo(null);

        createGUI();
    }

    // ============================================================
    // MAIN GUI
    // ============================================================

    private void createGUI() {

        JPanel mainPanel = new JPanel(new BorderLayout(15, 15));

        mainPanel.setBackground(BACKGROUND);

        mainPanel.setBorder(
                new EmptyBorder(15, 15, 15, 15)
        );

        // ========================================================
        // TITLE
        // ========================================================

        JLabel title = new JLabel(
                "INFIX TO POSTFIX CALCULATOR",
                SwingConstants.CENTER
        );

        title.setFont(
                new Font("SansSerif", Font.BOLD, 28)
        );

        title.setForeground(Color.WHITE);

        JPanel titlePanel = new JPanel(
                new BorderLayout()
        );

        titlePanel.setBackground(DARK);

        titlePanel.setBorder(
                new EmptyBorder(15, 10, 15, 10)
        );

        titlePanel.add(title, BorderLayout.CENTER);

        mainPanel.add(
                titlePanel,
                BorderLayout.NORTH
        );

        // ========================================================
        // CONTENT
        // ========================================================

        JPanel contentPanel = new JPanel();

        contentPanel.setLayout(
                new BoxLayout(
                        contentPanel,
                        BoxLayout.Y_AXIS
                )
        );

        contentPanel.setBackground(BACKGROUND);

        // Input
        contentPanel.add(createInputPanel());

        contentPanel.add(
                Box.createVerticalStrut(12)
        );

        // Postfix / Process
        contentPanel.add(createConversionPanel());

        contentPanel.add(
                Box.createVerticalStrut(12)
        );

        // Stack
        contentPanel.add(createStackPanel());

        JScrollPane scrollPane =
                new JScrollPane(contentPanel);

        scrollPane.setBorder(null);

        scrollPane.getVerticalScrollBar()
                .setUnitIncrement(16);

        mainPanel.add(
                scrollPane,
                BorderLayout.CENTER
        );

        setContentPane(mainPanel);
    }

    // ============================================================
    // INPUT PANEL
    // ============================================================

    private JPanel createInputPanel() {

        JPanel panel = new JPanel(
                new BorderLayout(10, 10)
        );

        panel.setBackground(WHITE);

        panel.setBorder(
                createSectionBorder(
                        "INFIX EXPRESSION"
                )
        );

        // --------------------------------------------------------
        // LABEL
        // --------------------------------------------------------

        JLabel label = new JLabel(
                "ENTER INFIX EXPRESSION:"
        );

        label.setFont(
                new Font(
                        "SansSerif",
                        Font.BOLD,
                        15
                )
        );

        // --------------------------------------------------------
        // INPUT FIELD
        // --------------------------------------------------------

        infixField = new JTextField();

        infixField.setFont(
                new Font(
                        "Monospaced",
                        Font.PLAIN,
                        19
                )
        );

        infixField.setPreferredSize(
                new Dimension(100, 45)
        );

        infixField.setToolTipText(
                "Example: (5 + 3) * 2"
        );

        JPanel inputArea =
                new JPanel(
                        new BorderLayout(10, 5)
                );

        inputArea.setBackground(WHITE);

        inputArea.add(
                label,
                BorderLayout.NORTH
        );

        inputArea.add(
                infixField,
                BorderLayout.CENTER
        );

        // --------------------------------------------------------
        // BUTTONS
        // --------------------------------------------------------

        JButton convertButton =
                createButton(
                        "CONVERT",
                        BLUE
                );

        JButton clearButton =
                createButton(
                        "CLEAR",
                        GRAY
                );

        JButton exitButton =
                createButton(
                        "EXIT",
                        RED
                );

        convertButton.addActionListener(
                e -> convertExpression()
        );

        clearButton.addActionListener(
                e -> clearAll()
        );

        exitButton.addActionListener(
                e -> System.exit(0)
        );

        // Press ENTER
        infixField.addActionListener(
                e -> convertExpression()
        );

        JPanel buttonsPanel =
                new JPanel(
                        new FlowLayout(
                                FlowLayout.RIGHT,
                                8,
                                0
                        )
                );

        buttonsPanel.setBackground(WHITE);

        buttonsPanel.add(convertButton);
        buttonsPanel.add(clearButton);
        buttonsPanel.add(exitButton);

        panel.add(
                inputArea,
                BorderLayout.CENTER
        );

        panel.add(
                buttonsPanel,
                BorderLayout.SOUTH
        );

        return panel;
    }

    // ============================================================
    // CONVERSION PANEL
    // ============================================================

    private JPanel createConversionPanel() {

        JPanel panel = new JPanel(
                new BorderLayout(10, 10)
        );

        panel.setBackground(WHITE);

        panel.setBorder(
                createSectionBorder(
                        "POSTFIX EXPRESSION / CONVERSION PROCESS"
                )
        );

        // --------------------------------------------------------
        // FINAL POSTFIX
        // --------------------------------------------------------

        JLabel resultTitle =
                new JLabel("FINAL POSTFIX:");

        resultTitle.setFont(
                new Font(
                        "SansSerif",
                        Font.BOLD,
                        15
                )
        );

        postfixResultLabel =
                new JLabel(" ");

        postfixResultLabel.setFont(
                new Font(
                        "Monospaced",
                        Font.BOLD,
                        21
                )
        );

        postfixResultLabel.setForeground(
                GREEN
        );

        postfixResultLabel.setOpaque(true);

        postfixResultLabel.setBackground(
                new Color(248, 250, 249)
        );

        postfixResultLabel.setBorder(
                BorderFactory.createCompoundBorder(
                        BorderFactory.createLineBorder(
                                new Color(200, 210, 220)
                        ),
                        new EmptyBorder(
                                8,
                                10,
                                8,
                                10
                        )
                )
        );

        JPanel resultPanel =
                new JPanel(
                        new BorderLayout(8, 5)
                );

        resultPanel.setBackground(WHITE);

        resultPanel.add(
                resultTitle,
                BorderLayout.NORTH
        );

        resultPanel.add(
                postfixResultLabel,
                BorderLayout.CENTER
        );

        // --------------------------------------------------------
        // STEP-BY-STEP PROCESS
        // --------------------------------------------------------

        conversionArea =
                new JTextArea();

        conversionArea.setEditable(false);

        conversionArea.setFont(
                new Font(
                        "Monospaced",
                        Font.PLAIN,
                        13
                )
        );

        conversionArea.setBackground(
                new Color(250, 250, 250)
        );

        conversionArea.setLineWrap(false);

        JScrollPane processScroll =
                new JScrollPane(
                        conversionArea
                );

        processScroll.setPreferredSize(
                new Dimension(100, 280)
        );

        processScroll.setBorder(
                BorderFactory.createTitledBorder(
                        "STEP-BY-STEP PROCESS"
                )
        );

        panel.add(
                resultPanel,
                BorderLayout.NORTH
        );

        panel.add(
                processScroll,
                BorderLayout.CENTER
        );

        return panel;
    }

    // ============================================================
    // STACK PANEL
    // ============================================================

    private JPanel createStackPanel() {

        JPanel panel = new JPanel(
                new BorderLayout(10, 10)
        );

        panel.setBackground(WHITE);

        panel.setBorder(
                createSectionBorder(
                        "STACK OPERATIONS"
                )
        );

        // ========================================================
        // LEFT SIDE - STACK OPERATION LOG
        // ========================================================

        stackOperationsArea =
                new JTextArea();

        stackOperationsArea.setEditable(false);

        stackOperationsArea.setFont(
                new Font(
                        "Monospaced",
                        Font.PLAIN,
                        14
                )
        );

        stackOperationsArea.setBackground(
                new Color(250, 250, 250)
        );

        stackOperationsArea.setLineWrap(false);

        JScrollPane operationsScroll =
                new JScrollPane(
                        stackOperationsArea
                );

        operationsScroll.setPreferredSize(
                new Dimension(450, 260)
        );

        operationsScroll.setBorder(
                BorderFactory.createTitledBorder(
                        "STACK OPERATION LOG"
                )
        );

        // ========================================================
        // RIGHT SIDE - VISUAL STACK
        // ========================================================

        visualStackPanel =
                new JPanel();

        visualStackPanel.setLayout(
                new BoxLayout(
                        visualStackPanel,
                        BoxLayout.Y_AXIS
                )
        );

        visualStackPanel.setBackground(
                new Color(250, 250, 250)
        );

        JScrollPane visualScroll =
                new JScrollPane(
                        visualStackPanel
                );

        visualScroll.setPreferredSize(
                new Dimension(250, 260)
        );

        visualScroll.setBorder(
                BorderFactory.createTitledBorder(
                        "CURRENT STACK"
                )
        );

        panel.add(
                operationsScroll,
                BorderLayout.CENTER
        );

        panel.add(
                visualScroll,
                BorderLayout.EAST
        );

        updateVisualStack(
                new ArrayList<>()
        );

        return panel;
    }

    // ============================================================
    // CONVERT
    // ============================================================

    private void convertExpression() {

        String expression =
                infixField.getText().trim();

        if (expression.isEmpty()) {

            JOptionPane.showMessageDialog(
                    this,
                    "Please enter an infix expression.",
                    "Input Required",
                    JOptionPane.WARNING_MESSAGE
            );

            return;
        }

        // Clear previous output
        conversionArea.setText("");

        stackOperationsArea.setText("");

        postfixResultLabel.setText(" ");

        updateVisualStack(
                new ArrayList<>()
        );

        try {

            // ====================================================
            // YOUR EXISTING CODE
            // ====================================================

            InfixToPostfix converter =
                    new InfixToPostfix();

            converter.Tokenize(expression);

            ArrayList<String> postfix =
                    converter.convert();

            // ====================================================
            // DISPLAY FINAL POSTFIX
            // ====================================================

            String finalPostfix =
                    String.join(
                            " ",
                            postfix
                    );

            postfixResultLabel.setText(
                    finalPostfix
            );

            // ====================================================
            // GUI STEP-BY-STEP VISUALIZATION
            // ====================================================

            simulateConversion(expression);

        } catch (Exception ex) {

            JOptionPane.showMessageDialog(
                    this,
                    "Unable to convert expression.\n\n"
                            + ex.getMessage(),
                    "Conversion Error",
                    JOptionPane.ERROR_MESSAGE
            );
        }
    }

    // ============================================================
    // STEP-BY-STEP SIMULATION
    //
    // IMPORTANT:
    // This does NOT modify your existing algorithm.
    //
    // It is only used by the GUI to SHOW what the algorithm
    // is doing.
    // ============================================================

    private void simulateConversion(
            String expression
    ) {

        List<String> tokens =
                tokenizeForDisplay(expression);

        ArrayList<String> stack =
                new ArrayList<>();

        ArrayList<String> postfix =
                new ArrayList<>();

        // --------------------------------------------------------
        // CREATE STACK
        // --------------------------------------------------------

        stackOperationsArea.append(
                "CREATE STACK\n"
        );

        stackOperationsArea.append(
                "------------------------------\n"
        );

        int step = 1;

        addStep(
                step++,
                "START",
                "Create Stack",
                postfix,
                stack
        );

        // --------------------------------------------------------
        // PROCESS TOKENS
        // --------------------------------------------------------

        for (String token : tokens) {

            // ====================================================
            // OPERAND
            // ====================================================

            if (isDisplayOperand(token)) {

                postfix.add(token);

                addStep(
                        step++,
                        token,
                        "ADD TO POSTFIX",
                        postfix,
                        stack
                );
            }

            // ====================================================
            // LEFT PARENTHESIS
            // ====================================================

            else if (token.equals("(")) {

                stack.add(token);

                stackOperationsArea.append(
                        "PUSH(" + token + ")\n"
                );

                updateVisualStack(stack);

                addStep(
                        step++,
                        token,
                        "PUSH TO STACK",
                        postfix,
                        stack
                );
            }

            // ====================================================
            // RIGHT PARENTHESIS
            // ====================================================

            else if (token.equals(")")) {

                while (
                        !stack.isEmpty()
                                &&
                        !stack.get(
                                stack.size() - 1
                        ).equals("(")
                ) {

                    String popped =
                            stack.remove(
                                    stack.size() - 1
                            );

                    postfix.add(popped);

                    stackOperationsArea.append(
                            "POP(" + popped + ")\n"
                    );

                    updateVisualStack(stack);

                    addStep(
                            step++,
                            token,
                            "POP " + popped
                                    + " TO POSTFIX",
                            postfix,
                            stack
                    );
                }

                if (!stack.isEmpty()
                        &&
                        stack.get(
                                stack.size() - 1
                        ).equals("(")) {

                    stack.remove(
                            stack.size() - 1
                    );

                    stackOperationsArea.append(
                            "POP(()\n"
                    );

                    updateVisualStack(stack);

                    addStep(
                            step++,
                            token,
                            "REMOVE (",
                            postfix,
                            stack
                    );
                }
            }

            // ====================================================
            // OPERATOR
            // ====================================================

            else if (isDisplayOperator(token)) {

                while (
                        !stack.isEmpty()
                                &&
                        !stack.get(
                                stack.size() - 1
                        ).equals("(")
                                &&
                        precedence(
                                stack.get(
                                        stack.size() - 1
                                )
                        )
                        >=
                        precedence(token)
                ) {

                    String popped =
                            stack.remove(
                                    stack.size() - 1
                            );

                    postfix.add(popped);

                    stackOperationsArea.append(
                            "POP(" + popped + ")\n"
                    );

                    updateVisualStack(stack);

                    addStep(
                            step++,
                            token,
                            "POP " + popped
                                    + " TO POSTFIX",
                            postfix,
                            stack
                    );
                }

                stack.add(token);

                stackOperationsArea.append(
                        "PUSH(" + token + ")\n"
                );

                updateVisualStack(stack);

                addStep(
                        step++,
                        token,
                        "PUSH TO STACK",
                        postfix,
                        stack
                );
            }
        }

        // --------------------------------------------------------
        // EMPTY STACK
        // --------------------------------------------------------

        while (!stack.isEmpty()) {

            String popped =
                    stack.remove(
                            stack.size() - 1
                    );

            if (popped.equals("(")) {

                continue;
            }

            postfix.add(popped);

            stackOperationsArea.append(
                    "POP(" + popped + ")\n"
            );

            updateVisualStack(stack);

            addStep(
                    step++,
                    "END",
                    "POP " + popped
                            + " TO POSTFIX",
                    postfix,
                    stack
            );
        }

        stackOperationsArea.append(
                "------------------------------\n"
        );

        stackOperationsArea.append(
                "STACK EMPTY\n"
        );

        updateVisualStack(stack);

        conversionArea.setCaretPosition(0);

        stackOperationsArea.setCaretPosition(0);
    }

    // ============================================================
    // ADD STEP
    // ============================================================

    private void addStep(
            int step,
            String token,
            String action,
            ArrayList<String> postfix,
            ArrayList<String> stack
    ) {

        String postfixText =
                String.join(
                        " ",
                        postfix
                );

        String stackText =
                stack.toString();

        conversionArea.append(
                String.format(
                        "STEP %-3d | TOKEN: %-4s | %-24s | POSTFIX: %-18s | STACK: %s%n",
                        step,
                        token,
                        action,
                        postfixText,
                        stackText
                )
        );
    }

    // ============================================================
    // TOKENIZE FOR DISPLAY ONLY
    //
    // This does not modify Tokenizer.java.
    // ============================================================

    private List<String> tokenizeForDisplay(
            String expression
    ) {

        ArrayList<String> tokens =
                new ArrayList<>();

        String operand = "";

        for (int i = 0;
             i < expression.length();
             i++) {

            char c =
                    expression.charAt(i);

            // Ignore spaces
            if (Character.isWhitespace(c)) {
                continue;
            }

            // Number
            if (Character.isDigit(c)) {

                operand += c;
            }

            // Operator / parenthesis
            else if (
                    c == '+'
                            ||
                    c == '-'
                            ||
                    c == '*'
                            ||
                    c == '/'
                            ||
                    c == '^'
                            ||
                    c == '('
                            ||
                    c == ')'
            ) {

                if (!operand.isEmpty()) {

                    tokens.add(operand);

                    operand = "";
                }

                tokens.add(
                        String.valueOf(c)
                );
            }
        }

        if (!operand.isEmpty()) {

            tokens.add(operand);
        }

        return tokens;
    }

    // ============================================================
    // OPERAND CHECK FOR DISPLAY
    // ============================================================

    private boolean isDisplayOperand(
            String token
    ) {

        if (token == null ||
                token.isEmpty()) {

            return false;
        }

        for (int i = 0;
             i < token.length();
             i++) {

            if (!Character.isDigit(
                    token.charAt(i)
            )) {

                return false;
            }
        }

        return true;
    }

    // ============================================================
    // OPERATOR CHECK
    // ============================================================

    private boolean isDisplayOperator(
            String token
    ) {

        return token.equals("+")
                || token.equals("-")
                || token.equals("*")
                || token.equals("/")
                || token.equals("^");
    }

    // ============================================================
    // PRECEDENCE FOR GUI DISPLAY
    // ============================================================

    private int precedence(
            String operator
    ) {

        switch (operator) {

            case "+":
            case "-":
                return 1;

            case "*":
            case "/":
                return 2;

            case "^":
                return 3;

            default:
                return 0;
        }
    }

    // ============================================================
    // VISUAL STACK
    // ============================================================

    private void updateVisualStack(
            ArrayList<String> stack
    ) {

        visualStackPanel.removeAll();

        if (stack.isEmpty()) {

            visualStackPanel.add(
                    Box.createVerticalGlue()
            );

            JLabel empty =
                    new JLabel("STACK EMPTY");

            empty.setFont(
                    new Font(
                            "SansSerif",
                            Font.BOLD,
                            15
                    )
            );

            empty.setForeground(GRAY);

            empty.setAlignmentX(
                    Component.CENTER_ALIGNMENT
            );

            visualStackPanel.add(empty);

            visualStackPanel.add(
                    Box.createVerticalGlue()
            );

        } else {

            JLabel top =
                    new JLabel("TOP");

            top.setFont(
                    new Font(
                            "SansSerif",
                            Font.BOLD,
                            12
                    )
            );

            top.setAlignmentX(
                    Component.CENTER_ALIGNMENT
            );

            visualStackPanel.add(top);

            visualStackPanel.add(
                    Box.createVerticalStrut(5)
            );

            // Show top of stack first
            for (int i = stack.size() - 1;
                 i >= 0;
                 i--) {

                JLabel item =
                        new JLabel(
                                "   "
                                        + stack.get(i)
                                        + "   "
                        );

                item.setFont(
                        new Font(
                                "Monospaced",
                                Font.BOLD,
                                18
                        )
                );

                item.setOpaque(true);

                item.setBackground(WHITE);

                item.setHorizontalAlignment(
                        SwingConstants.CENTER
                );

                item.setBorder(
                        BorderFactory.createLineBorder(
                                DARK
                        )
                );

                item.setAlignmentX(
                        Component.CENTER_ALIGNMENT
                );

                visualStackPanel.add(item);

                visualStackPanel.add(
                        Box.createVerticalStrut(2)
                );
            }
        }

        visualStackPanel.revalidate();

        visualStackPanel.repaint();
    }

    // ============================================================
    // CLEAR
    // ============================================================

    private void clearAll() {

        infixField.setText("");

        postfixResultLabel.setText(" ");

        conversionArea.setText("");

        stackOperationsArea.setText("");

        updateVisualStack(
                new ArrayList<>()
        );

        infixField.requestFocus();
    }

    // ============================================================
    // CREATE BUTTON
    // ============================================================

    private JButton createButton(
            String text,
            Color background
    ) {

        JButton button =
                new JButton(text);

        button.setFont(
                new Font(
                        "SansSerif",
                        Font.BOLD,
                        13
                )
        );

        button.setForeground(
                Color.WHITE
        );

        button.setBackground(
                background
        );

        button.setFocusPainted(false);

        button.setBorder(
                new EmptyBorder(
                        10,
                        18,
                        10,
                        18
                )
        );

        button.setCursor(
                new Cursor(
                        Cursor.HAND_CURSOR
                )
        );

        return button;
    }

    // ============================================================
    // SECTION BORDER
    // ============================================================

    private Border createSectionBorder(
            String title
    ) {

        return BorderFactory.createCompoundBorder(

                BorderFactory.createTitledBorder(
                        BorderFactory.createLineBorder(
                                new Color(
                                        210,
                                        215,
                                        220
                                )
                        ),
                        title,
                        TitledBorder.LEFT,
                        TitledBorder.TOP,
                        new Font(
                                "SansSerif",
                                Font.BOLD,
                                15
                        ),
                        DARK
                ),

                new EmptyBorder(
                        10,
                        10,
                        10,
                        10
                )
        );
    }

    // ============================================================
    // MAIN
    // ============================================================

    public static void main(
            String[] args
    ) {

        try {

            UIManager.setLookAndFeel(
                    UIManager
                            .getSystemLookAndFeelClassName()
            );

        } catch (Exception ignored) {
        }

        SwingUtilities.invokeLater(
                () -> {

                    Ui gui =
                            new Ui();

                    gui.setVisible(true);
                }
        );
    }
}