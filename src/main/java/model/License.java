package model;

import java.util.Arrays;
import java.util.Optional;

public enum License {
    NONE, TRAUMATIC, HUNTER, POLICE, MILITARY;

    public static Optional<License> valueOf(int id) {
        return Arrays.stream(values())
                .filter(license -> license.ordinal() == id)
                .findAny();
    }
}
