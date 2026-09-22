/**
 * Prints things out to the screen, when needed
 * Printing to the screen:
 *  System.out.println("hello");
 */
public class Screen {
    private final PhoneModel model;

    public Screen(PhoneModel model) {
        this.model = model;

        // Observer 1: imprime o dígito mais recente na tela
        this.model.addObserver(new Observer() {
            @Override
            public void update(int newDigit) {
                System.out.println(newDigit);
            }
        });

        // Observer 2: imprime "Agora discando ..." quando atinge 12 dígitos
        this.model.addObserver(new Observer() {
            @Override
            public void update(int newDigit) {
                if (Screen.this.model.getDigits().size() == 12) {
                    System.out.print("Agora discando ");
                    for (int digit : Screen.this.model.getDigits()) {
                        System.out.print(digit);
                    }
                    System.out.println("...");
                }
            }
        });
    }
}
