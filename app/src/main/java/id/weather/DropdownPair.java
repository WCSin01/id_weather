package id.weather;

import android.animation.ValueAnimator;
import android.view.ViewGroup;

public class DropdownPair {
    private final ViewGroup layout1, layout2;
    private final int closedHeight;
    private boolean layout1Open;

    /**
     * Pairs the given layouts as dropdowns which will open/close when the other is closed/opened.
     *
     * @param openLayout the layout which is initially open
     * @param closedLayout the layout which is initially closed
     */
    public DropdownPair(ViewGroup openLayout, ViewGroup closedLayout) {
        layout1 = openLayout;
        layout2 = closedLayout;

        // need to set default closed height now in case dropdowns are toggled during animation
        // don't need open height as well because this is encoded implicitly since they always
        // move in unison
        closedHeight = closedLayout.getLayoutParams().height;

        layout1Open = true;
    }

    /**
     * Toggles the state of the paired dropdowns.
     *
     * @param animDuration the duration of the open/close animation in milliseconds
     */
    public void toggle(int animDuration) {
        // find which layout is open and which is closed
        final ViewGroup openLayout, closedLayout;
        if (layout1Open) {
            openLayout = layout1;
            closedLayout = layout2;
        }
        else {
            openLayout = layout2;
            closedLayout = layout1;
        }

        // find current heights of the layouts to ensure smooth animation if toggled during
        // previous animation
        int currentOpenHeight = openLayout.getLayoutParams().height;
        int currentClosedHeight = closedLayout.getLayoutParams().height;

        // create animator for smooth transition
        ValueAnimator anim = ValueAnimator.ofInt(currentOpenHeight, closedHeight);
        anim.addUpdateListener(valueAnim -> {
            int val = (int)valueAnim.getAnimatedValue();

            ViewGroup.LayoutParams openParams = openLayout.getLayoutParams();
            openParams.height = val;
            openLayout.setLayoutParams(openParams);

            ViewGroup.LayoutParams closedParams = closedLayout.getLayoutParams();
            closedParams.height = currentClosedHeight + currentOpenHeight - val;
            closedLayout.setLayoutParams(closedParams);
        });

        anim.setDuration(animDuration).start();

        // swap open and closed layouts
        layout1Open = !layout1Open;
    }
}
