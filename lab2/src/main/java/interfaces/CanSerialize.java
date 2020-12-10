package interfaces;

import java.util.List;

/**
 * an interface that must be implemented by serialization classes
 */
public interface CanSerialize {
      /**
       * the fields must be written and read in the same order
       * @return list of fields in class
       */
      List<Object> fieldsToList();

      /**
       * the fields must be written and read in the same order
       * @param list which must be converted to fields in class
       */
      void listToFields(List<Object> list);
}
