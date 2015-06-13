package RectangleArea;

/**
 * Created by haha on 2015/6/13.
 */
public class Solution {
    public int computeArea(int A, int B, int C, int D, int E, int F, int G, int H) {
        int sumArea = (C - A) * (D - B) + (G - E) * (H - F);
        int w = (C < G ? C : G) - (A > E ? A : E);
        int h = (D < H ? D : H) - (B > F ? B : F);
        return w > 0 && h > 0 ? sumArea - w * h : sumArea;
    }
}
