/** Array based storage for Resumes */
public class ArrayStorage {
  private Resume[] storage = new Resume[10000];
  private int size;

  public void clear() { //done
    for (int i = 0; i < size; i++) {
      storage[i] = null;
    }
    size = 0;
  }

  public void save(Resume r) { //done
    storage[size++] = r;
  }

  public Resume get(String uuid) {//done
    for (int i = 0; i < size; i++) {
      if (storage[i].getUuid().equals(uuid)) {
        return storage[i];
      }
    }
    return null;
  }

  public void delete(String uuid) {
    for (int i = 0; i < size; i++) {
      if (storage[i].getUuid().equals(uuid)) {
        if (storage[i + 1] == null) {
          storage[i] = null;
        } else {
          System.arraycopy(storage, i + 1, storage, i, size - i - 1);
        }
        size--;
        break;
      }
    }
  }

  /** @return array, contains only Resumes in storage (without null) */
  public Resume[] getAll() { //done
    Resume[] all = new Resume[size];
    System.arraycopy(storage, 0, all, 0, size);
    return all;
  }

  public int size() {//done
    return size;
  }
}
