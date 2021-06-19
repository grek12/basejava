/**
 * Array based storage for Resumes
 */
public class ArrayStorage {
    Resume[] storage = new Resume[10000];
    int count = 0;

    void clear() {

    }

    void save(Resume r) {
        if (count < storage.length) {
            storage[count] = r;
            count++;
        }
    }

    Resume get(String uuid) {
        if (storage != null) {
            for (int i = 0; i < count; i++) {
                if (storage[i].uuid == uuid) {
                    return storage[i];
                }
            }
        }
        return null;
    }

    void delete(String uuid) {
        if (storage != null) {
            for (int i = 0; i < count; i++) {
                if (storage[i].uuid == uuid) {
                    int i2 = i;
                    for (int i3 = i2; i3 < count; i3++) {
                        storage[i3] = storage[i3 + 1];
                    }
                    count--;
                }
            }
        }
    }

    /**
     * @return array, contains only Resumes in storage (without null)
     */
    Resume[] getAll() {
        return new Resume[size()];
    }

    int size() {
        return count;
    }
}
