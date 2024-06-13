import java.util.*;
import java.awt.Point;

public class MyMatrix<T> implements Matrix<T> {
    private Map<Point, T> matrixEntries = new HashMap<>();


    @Override
    public int getRowCount() {
        Set<Point> allPoints = matrixEntries.keySet();
        int max = -1;
        for(Point p : allPoints){
            if(p.x > max) max = p.x;
        }
        return max + 1;
    }

    @Override
    public int getColumnCount() {
        Set<Point> allPoints = matrixEntries.keySet();
        int max = -1;
        for(Point p : allPoints){
            if(p.y > max) max = p.y;
        }
        return max + 1;
    }

    @Override
    public int getObjectCount() {
        return matrixEntries.values().size();
    }

    @Override
    public int getDistinctObjectCount() {
        Set<T> output = new HashSet<>();
//        for(T t : allT){
//            output.add(t);
//        }
        output.addAll(matrixEntries.values());
        return output.size();
    }

    @Override
    public Iterator<T> iterator() {
        return new DepthFirstIterator();
    }

    @Override
    public T get(int row, int column) {
        if(row < 0 || column < 0 || row > getRowCount() - 1 || column > getColumnCount() - 1) throw new IllegalArgumentException();
//        if(!matrixEntries.containsKey(new Point(row, column))) throw new NoSuchElementException();
        if(!matrixEntries.containsKey(new Point(row, column))) return null;
        else return matrixEntries.get(new Point(row, column));
    }

    @Override
    public T put(int row, int column, T value) {
        if(row < 0 || column < 0) throw new IllegalArgumentException();
//        if(value == null) throw new NullPointerException();
//        if(value instanceof String && ((String) value).isEmpty()) throw new IllegalArgumentException();
        T toReturn = null;
        if(matrixEntries.containsKey(new Point(row, column))) toReturn = matrixEntries.get(new Point(row, column));
        matrixEntries.put(new Point(row, column), value);
        return toReturn;
    }

    @Override
    public boolean contains(T value) {
        return matrixEntries.containsValue(value);
    }

    private class DepthFirstIterator implements Iterator<T>{
        private List<Point> orderedPoints;
        public DepthFirstIterator(){
            orderedPoints = new ArrayList<>();
            for(int i = 0; i < getColumnCount(); i++){
                for(int j = 0; j < getRowCount(); j++){
                    if(matrixEntries.get(new Point(j, i)) != null){
                        orderedPoints.add(new Point(j, i));
                    }
                }
            }
        }

        @Override
        public boolean hasNext() {
            if(!orderedPoints.isEmpty()) return true;
            else return false;
        }

        @Override
        public T next() {
            int first = 0;
            if(!hasNext()) throw new NoSuchElementException();
            Point p = orderedPoints.get(first);
            orderedPoints.remove(first);
            return matrixEntries.get(p);
        }

        @Override
        public void remove() {
            throw new UnsupportedOperationException();
        }
    }
}
