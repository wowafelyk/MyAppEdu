package com.example.fenix.fortest;

/**
 * Created by Fenix on 27.05.2015.
 */

        import java.util.Collections;
        import java.util.LinkedList;
        import java.util.List;
/** список точек */
public class Dots {

    /** слушатель DotChangeListener */
    public interface DotsChangeListener {
        /** @param dots точек, которые изменились */
        void onDotsChange(Dots dots);
    }
    private final LinkedList<Dot> dots = new LinkedList<Dot>();
    private final List<Dot> safeDots = Collections.unmodifiableList(dots);
    private DotsChangeListener dotsChangeListener;
    /** @param l нового слушателя изменений */
    public void setDotsChangeListener(DotsChangeListener l) {
        dotsChangeListener = l;
    }
    /** @return возврат последней добавленной точки или возврат null */
    public Dot getLastDot() {
        return (dots.size() <= 0) ? null : dots.getLast();
    }
    /** @return возврат списка точек */
    public List<Dot> getDots() { return safeDots; }
    /**
     * @param x координата по горизонтали
     * @param y координата по вертикали
     * @param color цвет
     * @param diameter размер точки.
     */
    public void addDot(float x, float y, int color, int diameter) {
        dots.add(new Dot(x, y, color, diameter));
        notifyListener();
    }
    /** удаление всех точек */
    public void clearDots() {
        dots.clear();
        notifyListener();
    }
    private void notifyListener() {
        if (null != dotsChangeListener) {
            dotsChangeListener.onDotsChange(this);
        }
    }
}