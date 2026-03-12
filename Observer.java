public interface Observer {
    void place(Integer key, CarViewData carViewData);
    void remove(Integer key);
    void refresh();
}