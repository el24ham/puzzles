package prisoners_red_blue_hats;

import java.util.ArrayList;

/**
 * Prisoner class
 *
 * <p>A prisoner has a hat, name and can be dead. A dead prisoner has {@code
 * false} value for it's {@code alive} property.</p>
 *
 * <p>Whenever prisoner is asked to guess the color of his hat, its {@code
 * guess} method is called and {@code observation} and {@code history} are
 * passed into it as parameter.</p>
 *
 * <p>{@code observation} is an {@code ArrayList} of the colors that the
 * prisoner can observe from the hats of front prisoners.</p>
 *
 * <p>{@code history} is an {@code ArrayList} of the colors shouted by
 * the previous prisoners.</p>
 *
 * @author Alireza Jafartash
 */
public class Prisoner {

    /**
     * The color of the prisoner hat
     */
    private final HatColor hatColor;

    /**
     * The name of the prisoner
     */
    private final String name;

    /**
     * Being alive
     */
    private boolean alive;

    /**
     * Construct a prisoner with given hat color and name.
     *
     * @param hatColor the color of the hat
     * @param name     the name
     */
    public Prisoner(HatColor hatColor, String name) {
        this.hatColor = hatColor;
        this.name = name;
        this.alive = true;
    }

    /**
     * Returns the color of the prisoner's hat
     *
     * @return the color of the prisoner's hat
     */
    public HatColor getHatColor() {
        return hatColor;
    }

    /**
     * Return the name of the prisoner
     *
     * @return the name of the prisoner
     */
    public String getName() {
        return name;
    }

    /**
     * Returns the aliveness of the prisoner
     *
     * @return the aliveness of the prisoner
     */
    public boolean isAlive() {
        return alive;
    }

    /**
     * Makes the prisoner dead
     */
    public void die() {
        alive = false;
    }

    /**
     * The strategy function. Prisoner must guess the color of his own hat
     * regarding the previous history and the observation from the next
     * prisoners.
     *
     * @param observation the colors that the prisoner can observe from the hats
     *                    of front prisoners
     * @param history     the colors shouted by the previous prisoners
     * @return the color the prisoner guessed
     */
    public HatColor guess(ArrayList<HatColor> observation,
                          ArrayList<HatColor> history) {
        HatColor c;
        int n = history.size();
        int m = observation.size();
        int r = 0;
        for (int i = 1; i < m; i++){
            if (observation.get(i).equals(HatColor.RED)){
                r++;
            }
        }

        int b = 0;
        for (int i = 1; i < m; i++){
            if (observation.get(i).equals(HatColor.BLUE)){
                b++;
            }
        }

        int B = 0;
        for (HatColor colorB : history) {
            if (colorB.equals(HatColor.BLUE)) {
                B++;
            }
        }

        int R = 0;
        for (HatColor colorR : history) {
            if (colorR.equals(HatColor.RED)) {
                R++;
            }
        }

        HatColor color;
        if (r % 2 == 0){
           color = HatColor.RED;
        }
        else {
            color = HatColor.BLUE;
        }
        if (n == 0){
            c = color;
        }
        else {
            if ((R+r) % 2 != 0){
                c = HatColor.BLUE;
            }
            else
                c = HatColor.RED;
        }
        return c;
    }
}
