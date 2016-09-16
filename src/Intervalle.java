/**
 * Created by tearsyu on 16-9-12.
 */
public class Intervalle {
    private int numMax, numMin, inf, sup;

    public Intervalle(int inf, int sup){
        numMax = inf;
        numMin = sup;
        this.inf = inf;
        this.sup = sup;
    }

    public void setNumMax(int numMax) {
        this.numMax = numMax;
    }

    public void setNumMin(int numMin) {this.numMin = numMin;}

    public int getNumMax() {return  numMax;}
    public int getNumMin() {return  numMin;}

    public int getInf() {
        return inf;
    }

    public int getSup() {
        return sup;
    }

    public int getMilieu(){
        int mid = (numMin + numMax)/2;
        return mid;
    }

    public boolean estVide(){
        boolean bool = false;
        if (numMax == numMin)
            bool = true;
        return bool;
    }
}
