public class MultiplyDataProv {
    // pamiętamy o słóku provide

    public static Object[] provideFirstArray() {
        return new Object[]{
                new Object[]{1, 2, 2},
                new Object[]{5, 2, 10},
                new Object[]{3, 4, 12},
                new Object[]{5, 3, 15},
        };
    }

    public static Object[] provideSecondArray() {
        return new Object[]{
                new Object[]{1, 2, 2},
                new Object[]{5, 4, 20},
                new Object[]{3, 3, 9},
                new Object[]{5, 5, 25},

        };
    }
}
