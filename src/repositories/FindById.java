package repositories;

import java.util.List;

public interface FindById<T> {
    T findById(int id);
}
//generic method