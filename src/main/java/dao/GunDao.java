package dao;

import model.Gun;

import java.util.Collection;
import java.util.Objects;
import java.util.Optional;

public interface GunDao {

    String save();

    default Optional<Gun> get(String id) {
        return getAll().stream()
                .filter(gun -> Objects.equals(gun.getId(), id))
                .findAny();
    }

    // update
    void remove(String id);

    Collection<Gun> getAll();
}
