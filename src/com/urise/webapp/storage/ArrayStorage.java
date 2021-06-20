package com.urise.webapp.storage;

import com.urise.webapp.model.Resume;

/**
 * Array based storage for Resumes
 */
public class ArrayStorage {
    private Resume[] storage = new Resume[10000];
    private int count = 0;

    public void clear() {
        for (int i = 0; i < count; i++) {
            storage[i] = null;
        }
        count = 0;
    }

    public void update(Resume r) {
        int index = getindex(r.getUuid());
        if (index == -1) {
            System.out.println("не найден");
        } else {
            storage[index] = r;
        }
    }

    public void save(Resume r) {
        int index = getindex(r.getUuid());
        if (index != -1) {
            System.out.println("уже есть ");
        } else if (isFull()) {
            System.out.println("переполнен");
        } else {
            storage[count] = r;
            count++;
        }

    }

    public Resume get(String uuid) {
        int index = getindex(uuid);
        if (index == -1) {
            System.out.println("не найден");
        } else {
            return storage[index];
        }
        return null;
    }

    public void delete(String uuid) {
        int i = getindex(uuid);
        if (i == -1) {
            System.out.println("не найден");
        } else {
            System.arraycopy(storage, i + 1, storage, i, count - i);
            count--;
        }
    }

    /**
     * @return array, contains only Resumes in storage (without null)
     */
    public Resume[] getAll() {
        Resume[] result = new Resume[count];
        for (int i = 0; i < count; i++) {
            result[i] = storage[i];
        }
        return result;
    }

    public int size() {
        return count;
    }

    private int getindex(String uuid) {
        for (int i = 0; i < count; i++) {
            if (storage[i].getUuid().equals(uuid)) {
                return i;
            }
        }
        return (-1);
    }

    private boolean isFull() {
        if (size() != storage.length) {
            return false;
        }
        return true;
    }

    private boolean isEmpty() {
        if (storage != null) {
            return false;
        }
        return true;

    }
}