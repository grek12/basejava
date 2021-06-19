import java.util.Arrays;

/**
 * Array based storage for Resumes
 */
public class ArrayStorage {
    Resume[] storage = new Resume[10000];
    int count = 0;

    void clear() {
        Arrays.fill(storage, 0, count, null);
        count=0;
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
                if (storage[i].uuid.equals(uuid)) {
                    return storage[i];
                }
            }
        }
        return null;
    }

    void delete(String uuid) {
        if (storage != null) {
            for (int i = 0; i < count; i++) {
                if (storage[i].uuid.equals(uuid)) {
                    int i2 = i;
                    System.arraycopy(storage, i2 + 1, storage, i2, count - i2);
                    count--;
                }
            }
        }
    }

    /**
     * @return array, contains only Resumes in storage (without null)
     */
    Resume[] getAll() {
        return storage;
    }

    int size() {
        return count;
    }
}
