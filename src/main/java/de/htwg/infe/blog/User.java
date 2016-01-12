/**
 * Autogenerated by Avro
 * 
 * DO NOT EDIT DIRECTLY
 */
package de.htwg.infe.blog;  
@SuppressWarnings("all")
@org.apache.avro.specific.AvroGenerated
public class User extends org.apache.avro.specific.SpecificRecordBase implements org.apache.avro.specific.SpecificRecord {
  public static final org.apache.avro.Schema SCHEMA$ = new org.apache.avro.Schema.Parser().parse("{\"type\":\"record\",\"name\":\"User\",\"namespace\":\"de.htwg.infe.blog\",\"fields\":[{\"name\":\"id\",\"type\":\"string\"},{\"name\":\"name\",\"type\":\"string\"},{\"name\":\"mail\",\"type\":\"string\"},{\"name\":\"bild\",\"type\":\"string\"}]}");
  public static org.apache.avro.Schema getClassSchema() { return SCHEMA$; }
  @Deprecated public java.lang.CharSequence id;
  @Deprecated public java.lang.CharSequence name;
  @Deprecated public java.lang.CharSequence mail;
  @Deprecated public java.lang.CharSequence bild;

  /**
   * Default constructor.  Note that this does not initialize fields
   * to their default values from the schema.  If that is desired then
   * one should use <code>newBuilder()</code>. 
   */
  public User() {}

  /**
   * All-args constructor.
   */
  public User(java.lang.CharSequence id, java.lang.CharSequence name, java.lang.CharSequence mail, java.lang.CharSequence bild) {
    this.id = id;
    this.name = name;
    this.mail = mail;
    this.bild = bild;
  }

  public org.apache.avro.Schema getSchema() { return SCHEMA$; }
  // Used by DatumWriter.  Applications should not call. 
  public java.lang.Object get(int field$) {
    switch (field$) {
    case 0: return id;
    case 1: return name;
    case 2: return mail;
    case 3: return bild;
    default: throw new org.apache.avro.AvroRuntimeException("Bad index");
    }
  }
  // Used by DatumReader.  Applications should not call. 
  @SuppressWarnings(value="unchecked")
  public void put(int field$, java.lang.Object value$) {
    switch (field$) {
    case 0: id = (java.lang.CharSequence)value$; break;
    case 1: name = (java.lang.CharSequence)value$; break;
    case 2: mail = (java.lang.CharSequence)value$; break;
    case 3: bild = (java.lang.CharSequence)value$; break;
    default: throw new org.apache.avro.AvroRuntimeException("Bad index");
    }
  }

  /**
   * Gets the value of the 'id' field.
   */
  public java.lang.CharSequence getId() {
    return id;
  }

  /**
   * Sets the value of the 'id' field.
   * @param value the value to set.
   */
  public void setId(java.lang.CharSequence value) {
    this.id = value;
  }

  /**
   * Gets the value of the 'name' field.
   */
  public java.lang.CharSequence getName() {
    return name;
  }

  /**
   * Sets the value of the 'name' field.
   * @param value the value to set.
   */
  public void setName(java.lang.CharSequence value) {
    this.name = value;
  }

  /**
   * Gets the value of the 'mail' field.
   */
  public java.lang.CharSequence getMail() {
    return mail;
  }

  /**
   * Sets the value of the 'mail' field.
   * @param value the value to set.
   */
  public void setMail(java.lang.CharSequence value) {
    this.mail = value;
  }

  /**
   * Gets the value of the 'bild' field.
   */
  public java.lang.CharSequence getBild() {
    return bild;
  }

  /**
   * Sets the value of the 'bild' field.
   * @param value the value to set.
   */
  public void setBild(java.lang.CharSequence value) {
    this.bild = value;
  }

  /** Creates a new User RecordBuilder */
  public static de.htwg.infe.blog.User.Builder newBuilder() {
    return new de.htwg.infe.blog.User.Builder();
  }
  
  /** Creates a new User RecordBuilder by copying an existing Builder */
  public static de.htwg.infe.blog.User.Builder newBuilder(de.htwg.infe.blog.User.Builder other) {
    return new de.htwg.infe.blog.User.Builder(other);
  }
  
  /** Creates a new User RecordBuilder by copying an existing User instance */
  public static de.htwg.infe.blog.User.Builder newBuilder(de.htwg.infe.blog.User other) {
    return new de.htwg.infe.blog.User.Builder(other);
  }
  
  /**
   * RecordBuilder for User instances.
   */
  public static class Builder extends org.apache.avro.specific.SpecificRecordBuilderBase<User>
    implements org.apache.avro.data.RecordBuilder<User> {

    private java.lang.CharSequence id;
    private java.lang.CharSequence name;
    private java.lang.CharSequence mail;
    private java.lang.CharSequence bild;

    /** Creates a new Builder */
    private Builder() {
      super(de.htwg.infe.blog.User.SCHEMA$);
    }
    
    /** Creates a Builder by copying an existing Builder */
    private Builder(de.htwg.infe.blog.User.Builder other) {
      super(other);
      if (isValidValue(fields()[0], other.id)) {
        this.id = data().deepCopy(fields()[0].schema(), other.id);
        fieldSetFlags()[0] = true;
      }
      if (isValidValue(fields()[1], other.name)) {
        this.name = data().deepCopy(fields()[1].schema(), other.name);
        fieldSetFlags()[1] = true;
      }
      if (isValidValue(fields()[2], other.mail)) {
        this.mail = data().deepCopy(fields()[2].schema(), other.mail);
        fieldSetFlags()[2] = true;
      }
      if (isValidValue(fields()[3], other.bild)) {
        this.bild = data().deepCopy(fields()[3].schema(), other.bild);
        fieldSetFlags()[3] = true;
      }
    }
    
    /** Creates a Builder by copying an existing User instance */
    private Builder(de.htwg.infe.blog.User other) {
            super(de.htwg.infe.blog.User.SCHEMA$);
      if (isValidValue(fields()[0], other.id)) {
        this.id = data().deepCopy(fields()[0].schema(), other.id);
        fieldSetFlags()[0] = true;
      }
      if (isValidValue(fields()[1], other.name)) {
        this.name = data().deepCopy(fields()[1].schema(), other.name);
        fieldSetFlags()[1] = true;
      }
      if (isValidValue(fields()[2], other.mail)) {
        this.mail = data().deepCopy(fields()[2].schema(), other.mail);
        fieldSetFlags()[2] = true;
      }
      if (isValidValue(fields()[3], other.bild)) {
        this.bild = data().deepCopy(fields()[3].schema(), other.bild);
        fieldSetFlags()[3] = true;
      }
    }

    /** Gets the value of the 'id' field */
    public java.lang.CharSequence getId() {
      return id;
    }
    
    /** Sets the value of the 'id' field */
    public de.htwg.infe.blog.User.Builder setId(java.lang.CharSequence value) {
      validate(fields()[0], value);
      this.id = value;
      fieldSetFlags()[0] = true;
      return this; 
    }
    
    /** Checks whether the 'id' field has been set */
    public boolean hasId() {
      return fieldSetFlags()[0];
    }
    
    /** Clears the value of the 'id' field */
    public de.htwg.infe.blog.User.Builder clearId() {
      id = null;
      fieldSetFlags()[0] = false;
      return this;
    }

    /** Gets the value of the 'name' field */
    public java.lang.CharSequence getName() {
      return name;
    }
    
    /** Sets the value of the 'name' field */
    public de.htwg.infe.blog.User.Builder setName(java.lang.CharSequence value) {
      validate(fields()[1], value);
      this.name = value;
      fieldSetFlags()[1] = true;
      return this; 
    }
    
    /** Checks whether the 'name' field has been set */
    public boolean hasName() {
      return fieldSetFlags()[1];
    }
    
    /** Clears the value of the 'name' field */
    public de.htwg.infe.blog.User.Builder clearName() {
      name = null;
      fieldSetFlags()[1] = false;
      return this;
    }

    /** Gets the value of the 'mail' field */
    public java.lang.CharSequence getMail() {
      return mail;
    }
    
    /** Sets the value of the 'mail' field */
    public de.htwg.infe.blog.User.Builder setMail(java.lang.CharSequence value) {
      validate(fields()[2], value);
      this.mail = value;
      fieldSetFlags()[2] = true;
      return this; 
    }
    
    /** Checks whether the 'mail' field has been set */
    public boolean hasMail() {
      return fieldSetFlags()[2];
    }
    
    /** Clears the value of the 'mail' field */
    public de.htwg.infe.blog.User.Builder clearMail() {
      mail = null;
      fieldSetFlags()[2] = false;
      return this;
    }

    /** Gets the value of the 'bild' field */
    public java.lang.CharSequence getBild() {
      return bild;
    }
    
    /** Sets the value of the 'bild' field */
    public de.htwg.infe.blog.User.Builder setBild(java.lang.CharSequence value) {
      validate(fields()[3], value);
      this.bild = value;
      fieldSetFlags()[3] = true;
      return this; 
    }
    
    /** Checks whether the 'bild' field has been set */
    public boolean hasBild() {
      return fieldSetFlags()[3];
    }
    
    /** Clears the value of the 'bild' field */
    public de.htwg.infe.blog.User.Builder clearBild() {
      bild = null;
      fieldSetFlags()[3] = false;
      return this;
    }

    //@Override
    public User build() {
      try {
        User record = new User();
        record.id = fieldSetFlags()[0] ? this.id : (java.lang.CharSequence) defaultValue(fields()[0]);
        record.name = fieldSetFlags()[1] ? this.name : (java.lang.CharSequence) defaultValue(fields()[1]);
        record.mail = fieldSetFlags()[2] ? this.mail : (java.lang.CharSequence) defaultValue(fields()[2]);
        record.bild = fieldSetFlags()[3] ? this.bild : (java.lang.CharSequence) defaultValue(fields()[3]);
        return record;
      } catch (Exception e) {
        throw new org.apache.avro.AvroRuntimeException(e);
      }
    }
  }
}
