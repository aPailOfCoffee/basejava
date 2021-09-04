/** Array based storage for Resumes */
public class ArrayStorage {
  private Resume[] storage = new Resume[10000];
  private int size;

  /** Null all Resumes in the storage */
  public void clear() {
    for (int i = 0; i < size; i++) {
      storage[i] = null;
    }
    size = 0;
  }

  /** @param r - Resume that will be added to the storage */
  public void save(Resume r) {
    storage[size++] = r;
  }

  /**
   * @param uuid of the searched Resume.
   * @return Resume with specified uuid
   */
  public Resume get(String uuid) {
    for (int i = 0; i < size; i++) {
      if (storage[i].getUuid().equals(uuid)) {
        return storage[i];
      }
    }
    return null;
  }

  /**
   * Shifts all Resumes to the left, into the place of the deleted one.
   * If deleted Resume is last - just null it.
   * size - i + 1 - count of Resumes that contains after deleted one
   * @param uuid Resume that should be deleted
   */
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
  public Resume[] getAll() {
    Resume[] all = new Resume[size];
    System.arraycopy(storage, 0, all, 0, size);
    return all;
  }

  /** @return count of not-null Resumes contained in the storage */
  public int size() {
    return size;
  }
}
