// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: customer_proto.proto

package com.mbrdi.protobufs;

/**
 * Protobuf type {@code com.mbrdi.protobufs.CustomerTransferProto}
 */
public final class CustomerTransferProto extends
    com.google.protobuf.GeneratedMessageV3 implements
    // @@protoc_insertion_point(message_implements:com.mbrdi.protobufs.CustomerTransferProto)
    CustomerTransferProtoOrBuilder {
private static final long serialVersionUID = 0L;
  // Use CustomerTransferProto.newBuilder() to construct.
  private CustomerTransferProto(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
    super(builder);
  }
  private CustomerTransferProto() {
    customers_ = java.util.Collections.emptyList();
  }

  @java.lang.Override
  @SuppressWarnings({"unused"})
  protected java.lang.Object newInstance(
      UnusedPrivateParameter unused) {
    return new CustomerTransferProto();
  }

  @java.lang.Override
  public final com.google.protobuf.UnknownFieldSet
  getUnknownFields() {
    return this.unknownFields;
  }
  private CustomerTransferProto(
      com.google.protobuf.CodedInputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    this();
    if (extensionRegistry == null) {
      throw new java.lang.NullPointerException();
    }
    int mutable_bitField0_ = 0;
    com.google.protobuf.UnknownFieldSet.Builder unknownFields =
        com.google.protobuf.UnknownFieldSet.newBuilder();
    try {
      boolean done = false;
      while (!done) {
        int tag = input.readTag();
        switch (tag) {
          case 0:
            done = true;
            break;
          case 8: {
            bitField0_ |= 0x00000001;
            isUpdate_ = input.readBool();
            break;
          }
          case 16: {
            bitField0_ |= 0x00000002;
            isXmlfile_ = input.readBool();
            break;
          }
          case 26: {
            if (!((mutable_bitField0_ & 0x00000004) != 0)) {
              customers_ = new java.util.ArrayList<com.mbrdi.protobufs.CustomerProto>();
              mutable_bitField0_ |= 0x00000004;
            }
            customers_.add(
                input.readMessage(com.mbrdi.protobufs.CustomerProto.parser(), extensionRegistry));
            break;
          }
          default: {
            if (!parseUnknownField(
                input, unknownFields, extensionRegistry, tag)) {
              done = true;
            }
            break;
          }
        }
      }
    } catch (com.google.protobuf.InvalidProtocolBufferException e) {
      throw e.setUnfinishedMessage(this);
    } catch (java.io.IOException e) {
      throw new com.google.protobuf.InvalidProtocolBufferException(
          e).setUnfinishedMessage(this);
    } finally {
      if (((mutable_bitField0_ & 0x00000004) != 0)) {
        customers_ = java.util.Collections.unmodifiableList(customers_);
      }
      this.unknownFields = unknownFields.build();
      makeExtensionsImmutable();
    }
  }
  public static final com.google.protobuf.Descriptors.Descriptor
      getDescriptor() {
    return com.mbrdi.protobufs.CustomerProtoOuterClass.internal_static_com_mbrdi_protobufs_CustomerTransferProto_descriptor;
  }

  @java.lang.Override
  protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internalGetFieldAccessorTable() {
    return com.mbrdi.protobufs.CustomerProtoOuterClass.internal_static_com_mbrdi_protobufs_CustomerTransferProto_fieldAccessorTable
        .ensureFieldAccessorsInitialized(
            com.mbrdi.protobufs.CustomerTransferProto.class, com.mbrdi.protobufs.CustomerTransferProto.Builder.class);
  }

  private int bitField0_;
  public static final int IS_UPDATE_FIELD_NUMBER = 1;
  private boolean isUpdate_;
  /**
   * <code>optional bool is_update = 1;</code>
   * @return Whether the isUpdate field is set.
   */
  @java.lang.Override
  public boolean hasIsUpdate() {
    return ((bitField0_ & 0x00000001) != 0);
  }
  /**
   * <code>optional bool is_update = 1;</code>
   * @return The isUpdate.
   */
  @java.lang.Override
  public boolean getIsUpdate() {
    return isUpdate_;
  }

  public static final int IS_XMLFILE_FIELD_NUMBER = 2;
  private boolean isXmlfile_;
  /**
   * <code>optional bool is_xmlfile = 2;</code>
   * @return Whether the isXmlfile field is set.
   */
  @java.lang.Override
  public boolean hasIsXmlfile() {
    return ((bitField0_ & 0x00000002) != 0);
  }
  /**
   * <code>optional bool is_xmlfile = 2;</code>
   * @return The isXmlfile.
   */
  @java.lang.Override
  public boolean getIsXmlfile() {
    return isXmlfile_;
  }

  public static final int CUSTOMERS_FIELD_NUMBER = 3;
  private java.util.List<com.mbrdi.protobufs.CustomerProto> customers_;
  /**
   * <code>repeated .com.mbrdi.protobufs.CustomerProto customers = 3;</code>
   */
  @java.lang.Override
  public java.util.List<com.mbrdi.protobufs.CustomerProto> getCustomersList() {
    return customers_;
  }
  /**
   * <code>repeated .com.mbrdi.protobufs.CustomerProto customers = 3;</code>
   */
  @java.lang.Override
  public java.util.List<? extends com.mbrdi.protobufs.CustomerProtoOrBuilder> 
      getCustomersOrBuilderList() {
    return customers_;
  }
  /**
   * <code>repeated .com.mbrdi.protobufs.CustomerProto customers = 3;</code>
   */
  @java.lang.Override
  public int getCustomersCount() {
    return customers_.size();
  }
  /**
   * <code>repeated .com.mbrdi.protobufs.CustomerProto customers = 3;</code>
   */
  @java.lang.Override
  public com.mbrdi.protobufs.CustomerProto getCustomers(int index) {
    return customers_.get(index);
  }
  /**
   * <code>repeated .com.mbrdi.protobufs.CustomerProto customers = 3;</code>
   */
  @java.lang.Override
  public com.mbrdi.protobufs.CustomerProtoOrBuilder getCustomersOrBuilder(
      int index) {
    return customers_.get(index);
  }

  private byte memoizedIsInitialized = -1;
  @java.lang.Override
  public final boolean isInitialized() {
    byte isInitialized = memoizedIsInitialized;
    if (isInitialized == 1) return true;
    if (isInitialized == 0) return false;

    memoizedIsInitialized = 1;
    return true;
  }

  @java.lang.Override
  public void writeTo(com.google.protobuf.CodedOutputStream output)
                      throws java.io.IOException {
    if (((bitField0_ & 0x00000001) != 0)) {
      output.writeBool(1, isUpdate_);
    }
    if (((bitField0_ & 0x00000002) != 0)) {
      output.writeBool(2, isXmlfile_);
    }
    for (int i = 0; i < customers_.size(); i++) {
      output.writeMessage(3, customers_.get(i));
    }
    unknownFields.writeTo(output);
  }

  @java.lang.Override
  public int getSerializedSize() {
    int size = memoizedSize;
    if (size != -1) return size;

    size = 0;
    if (((bitField0_ & 0x00000001) != 0)) {
      size += com.google.protobuf.CodedOutputStream
        .computeBoolSize(1, isUpdate_);
    }
    if (((bitField0_ & 0x00000002) != 0)) {
      size += com.google.protobuf.CodedOutputStream
        .computeBoolSize(2, isXmlfile_);
    }
    for (int i = 0; i < customers_.size(); i++) {
      size += com.google.protobuf.CodedOutputStream
        .computeMessageSize(3, customers_.get(i));
    }
    size += unknownFields.getSerializedSize();
    memoizedSize = size;
    return size;
  }

  @java.lang.Override
  public boolean equals(final java.lang.Object obj) {
    if (obj == this) {
     return true;
    }
    if (!(obj instanceof com.mbrdi.protobufs.CustomerTransferProto)) {
      return super.equals(obj);
    }
    com.mbrdi.protobufs.CustomerTransferProto other = (com.mbrdi.protobufs.CustomerTransferProto) obj;

    if (hasIsUpdate() != other.hasIsUpdate()) return false;
    if (hasIsUpdate()) {
      if (getIsUpdate()
          != other.getIsUpdate()) return false;
    }
    if (hasIsXmlfile() != other.hasIsXmlfile()) return false;
    if (hasIsXmlfile()) {
      if (getIsXmlfile()
          != other.getIsXmlfile()) return false;
    }
    if (!getCustomersList()
        .equals(other.getCustomersList())) return false;
    if (!unknownFields.equals(other.unknownFields)) return false;
    return true;
  }

  @java.lang.Override
  public int hashCode() {
    if (memoizedHashCode != 0) {
      return memoizedHashCode;
    }
    int hash = 41;
    hash = (19 * hash) + getDescriptor().hashCode();
    if (hasIsUpdate()) {
      hash = (37 * hash) + IS_UPDATE_FIELD_NUMBER;
      hash = (53 * hash) + com.google.protobuf.Internal.hashBoolean(
          getIsUpdate());
    }
    if (hasIsXmlfile()) {
      hash = (37 * hash) + IS_XMLFILE_FIELD_NUMBER;
      hash = (53 * hash) + com.google.protobuf.Internal.hashBoolean(
          getIsXmlfile());
    }
    if (getCustomersCount() > 0) {
      hash = (37 * hash) + CUSTOMERS_FIELD_NUMBER;
      hash = (53 * hash) + getCustomersList().hashCode();
    }
    hash = (29 * hash) + unknownFields.hashCode();
    memoizedHashCode = hash;
    return hash;
  }

  public static com.mbrdi.protobufs.CustomerTransferProto parseFrom(
      java.nio.ByteBuffer data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static com.mbrdi.protobufs.CustomerTransferProto parseFrom(
      java.nio.ByteBuffer data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static com.mbrdi.protobufs.CustomerTransferProto parseFrom(
      com.google.protobuf.ByteString data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static com.mbrdi.protobufs.CustomerTransferProto parseFrom(
      com.google.protobuf.ByteString data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static com.mbrdi.protobufs.CustomerTransferProto parseFrom(byte[] data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static com.mbrdi.protobufs.CustomerTransferProto parseFrom(
      byte[] data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static com.mbrdi.protobufs.CustomerTransferProto parseFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static com.mbrdi.protobufs.CustomerTransferProto parseFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }
  public static com.mbrdi.protobufs.CustomerTransferProto parseDelimitedFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input);
  }
  public static com.mbrdi.protobufs.CustomerTransferProto parseDelimitedFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
  }
  public static com.mbrdi.protobufs.CustomerTransferProto parseFrom(
      com.google.protobuf.CodedInputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static com.mbrdi.protobufs.CustomerTransferProto parseFrom(
      com.google.protobuf.CodedInputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }

  @java.lang.Override
  public Builder newBuilderForType() { return newBuilder(); }
  public static Builder newBuilder() {
    return DEFAULT_INSTANCE.toBuilder();
  }
  public static Builder newBuilder(com.mbrdi.protobufs.CustomerTransferProto prototype) {
    return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
  }
  @java.lang.Override
  public Builder toBuilder() {
    return this == DEFAULT_INSTANCE
        ? new Builder() : new Builder().mergeFrom(this);
  }

  @java.lang.Override
  protected Builder newBuilderForType(
      com.google.protobuf.GeneratedMessageV3.BuilderParent parent) {
    Builder builder = new Builder(parent);
    return builder;
  }
  /**
   * Protobuf type {@code com.mbrdi.protobufs.CustomerTransferProto}
   */
  public static final class Builder extends
      com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
      // @@protoc_insertion_point(builder_implements:com.mbrdi.protobufs.CustomerTransferProto)
      com.mbrdi.protobufs.CustomerTransferProtoOrBuilder {
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return com.mbrdi.protobufs.CustomerProtoOuterClass.internal_static_com_mbrdi_protobufs_CustomerTransferProto_descriptor;
    }

    @java.lang.Override
    protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return com.mbrdi.protobufs.CustomerProtoOuterClass.internal_static_com_mbrdi_protobufs_CustomerTransferProto_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              com.mbrdi.protobufs.CustomerTransferProto.class, com.mbrdi.protobufs.CustomerTransferProto.Builder.class);
    }

    // Construct using com.mbrdi.protobufs.CustomerTransferProto.newBuilder()
    private Builder() {
      maybeForceBuilderInitialization();
    }

    private Builder(
        com.google.protobuf.GeneratedMessageV3.BuilderParent parent) {
      super(parent);
      maybeForceBuilderInitialization();
    }
    private void maybeForceBuilderInitialization() {
      if (com.google.protobuf.GeneratedMessageV3
              .alwaysUseFieldBuilders) {
        getCustomersFieldBuilder();
      }
    }
    @java.lang.Override
    public Builder clear() {
      super.clear();
      isUpdate_ = false;
      bitField0_ = (bitField0_ & ~0x00000001);
      isXmlfile_ = false;
      bitField0_ = (bitField0_ & ~0x00000002);
      if (customersBuilder_ == null) {
        customers_ = java.util.Collections.emptyList();
        bitField0_ = (bitField0_ & ~0x00000004);
      } else {
        customersBuilder_.clear();
      }
      return this;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.Descriptor
        getDescriptorForType() {
      return com.mbrdi.protobufs.CustomerProtoOuterClass.internal_static_com_mbrdi_protobufs_CustomerTransferProto_descriptor;
    }

    @java.lang.Override
    public com.mbrdi.protobufs.CustomerTransferProto getDefaultInstanceForType() {
      return com.mbrdi.protobufs.CustomerTransferProto.getDefaultInstance();
    }

    @java.lang.Override
    public com.mbrdi.protobufs.CustomerTransferProto build() {
      com.mbrdi.protobufs.CustomerTransferProto result = buildPartial();
      if (!result.isInitialized()) {
        throw newUninitializedMessageException(result);
      }
      return result;
    }

    @java.lang.Override
    public com.mbrdi.protobufs.CustomerTransferProto buildPartial() {
      com.mbrdi.protobufs.CustomerTransferProto result = new com.mbrdi.protobufs.CustomerTransferProto(this);
      int from_bitField0_ = bitField0_;
      int to_bitField0_ = 0;
      if (((from_bitField0_ & 0x00000001) != 0)) {
        result.isUpdate_ = isUpdate_;
        to_bitField0_ |= 0x00000001;
      }
      if (((from_bitField0_ & 0x00000002) != 0)) {
        result.isXmlfile_ = isXmlfile_;
        to_bitField0_ |= 0x00000002;
      }
      if (customersBuilder_ == null) {
        if (((bitField0_ & 0x00000004) != 0)) {
          customers_ = java.util.Collections.unmodifiableList(customers_);
          bitField0_ = (bitField0_ & ~0x00000004);
        }
        result.customers_ = customers_;
      } else {
        result.customers_ = customersBuilder_.build();
      }
      result.bitField0_ = to_bitField0_;
      onBuilt();
      return result;
    }

    @java.lang.Override
    public Builder clone() {
      return super.clone();
    }
    @java.lang.Override
    public Builder setField(
        com.google.protobuf.Descriptors.FieldDescriptor field,
        java.lang.Object value) {
      return super.setField(field, value);
    }
    @java.lang.Override
    public Builder clearField(
        com.google.protobuf.Descriptors.FieldDescriptor field) {
      return super.clearField(field);
    }
    @java.lang.Override
    public Builder clearOneof(
        com.google.protobuf.Descriptors.OneofDescriptor oneof) {
      return super.clearOneof(oneof);
    }
    @java.lang.Override
    public Builder setRepeatedField(
        com.google.protobuf.Descriptors.FieldDescriptor field,
        int index, java.lang.Object value) {
      return super.setRepeatedField(field, index, value);
    }
    @java.lang.Override
    public Builder addRepeatedField(
        com.google.protobuf.Descriptors.FieldDescriptor field,
        java.lang.Object value) {
      return super.addRepeatedField(field, value);
    }
    @java.lang.Override
    public Builder mergeFrom(com.google.protobuf.Message other) {
      if (other instanceof com.mbrdi.protobufs.CustomerTransferProto) {
        return mergeFrom((com.mbrdi.protobufs.CustomerTransferProto)other);
      } else {
        super.mergeFrom(other);
        return this;
      }
    }

    public Builder mergeFrom(com.mbrdi.protobufs.CustomerTransferProto other) {
      if (other == com.mbrdi.protobufs.CustomerTransferProto.getDefaultInstance()) return this;
      if (other.hasIsUpdate()) {
        setIsUpdate(other.getIsUpdate());
      }
      if (other.hasIsXmlfile()) {
        setIsXmlfile(other.getIsXmlfile());
      }
      if (customersBuilder_ == null) {
        if (!other.customers_.isEmpty()) {
          if (customers_.isEmpty()) {
            customers_ = other.customers_;
            bitField0_ = (bitField0_ & ~0x00000004);
          } else {
            ensureCustomersIsMutable();
            customers_.addAll(other.customers_);
          }
          onChanged();
        }
      } else {
        if (!other.customers_.isEmpty()) {
          if (customersBuilder_.isEmpty()) {
            customersBuilder_.dispose();
            customersBuilder_ = null;
            customers_ = other.customers_;
            bitField0_ = (bitField0_ & ~0x00000004);
            customersBuilder_ = 
              com.google.protobuf.GeneratedMessageV3.alwaysUseFieldBuilders ?
                 getCustomersFieldBuilder() : null;
          } else {
            customersBuilder_.addAllMessages(other.customers_);
          }
        }
      }
      this.mergeUnknownFields(other.unknownFields);
      onChanged();
      return this;
    }

    @java.lang.Override
    public final boolean isInitialized() {
      return true;
    }

    @java.lang.Override
    public Builder mergeFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      com.mbrdi.protobufs.CustomerTransferProto parsedMessage = null;
      try {
        parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
      } catch (com.google.protobuf.InvalidProtocolBufferException e) {
        parsedMessage = (com.mbrdi.protobufs.CustomerTransferProto) e.getUnfinishedMessage();
        throw e.unwrapIOException();
      } finally {
        if (parsedMessage != null) {
          mergeFrom(parsedMessage);
        }
      }
      return this;
    }
    private int bitField0_;

    private boolean isUpdate_ ;
    /**
     * <code>optional bool is_update = 1;</code>
     * @return Whether the isUpdate field is set.
     */
    @java.lang.Override
    public boolean hasIsUpdate() {
      return ((bitField0_ & 0x00000001) != 0);
    }
    /**
     * <code>optional bool is_update = 1;</code>
     * @return The isUpdate.
     */
    @java.lang.Override
    public boolean getIsUpdate() {
      return isUpdate_;
    }
    /**
     * <code>optional bool is_update = 1;</code>
     * @param value The isUpdate to set.
     * @return This builder for chaining.
     */
    public Builder setIsUpdate(boolean value) {
      bitField0_ |= 0x00000001;
      isUpdate_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>optional bool is_update = 1;</code>
     * @return This builder for chaining.
     */
    public Builder clearIsUpdate() {
      bitField0_ = (bitField0_ & ~0x00000001);
      isUpdate_ = false;
      onChanged();
      return this;
    }

    private boolean isXmlfile_ ;
    /**
     * <code>optional bool is_xmlfile = 2;</code>
     * @return Whether the isXmlfile field is set.
     */
    @java.lang.Override
    public boolean hasIsXmlfile() {
      return ((bitField0_ & 0x00000002) != 0);
    }
    /**
     * <code>optional bool is_xmlfile = 2;</code>
     * @return The isXmlfile.
     */
    @java.lang.Override
    public boolean getIsXmlfile() {
      return isXmlfile_;
    }
    /**
     * <code>optional bool is_xmlfile = 2;</code>
     * @param value The isXmlfile to set.
     * @return This builder for chaining.
     */
    public Builder setIsXmlfile(boolean value) {
      bitField0_ |= 0x00000002;
      isXmlfile_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>optional bool is_xmlfile = 2;</code>
     * @return This builder for chaining.
     */
    public Builder clearIsXmlfile() {
      bitField0_ = (bitField0_ & ~0x00000002);
      isXmlfile_ = false;
      onChanged();
      return this;
    }

    private java.util.List<com.mbrdi.protobufs.CustomerProto> customers_ =
      java.util.Collections.emptyList();
    private void ensureCustomersIsMutable() {
      if (!((bitField0_ & 0x00000004) != 0)) {
        customers_ = new java.util.ArrayList<com.mbrdi.protobufs.CustomerProto>(customers_);
        bitField0_ |= 0x00000004;
       }
    }

    private com.google.protobuf.RepeatedFieldBuilderV3<
        com.mbrdi.protobufs.CustomerProto, com.mbrdi.protobufs.CustomerProto.Builder, com.mbrdi.protobufs.CustomerProtoOrBuilder> customersBuilder_;

    /**
     * <code>repeated .com.mbrdi.protobufs.CustomerProto customers = 3;</code>
     */
    public java.util.List<com.mbrdi.protobufs.CustomerProto> getCustomersList() {
      if (customersBuilder_ == null) {
        return java.util.Collections.unmodifiableList(customers_);
      } else {
        return customersBuilder_.getMessageList();
      }
    }
    /**
     * <code>repeated .com.mbrdi.protobufs.CustomerProto customers = 3;</code>
     */
    public int getCustomersCount() {
      if (customersBuilder_ == null) {
        return customers_.size();
      } else {
        return customersBuilder_.getCount();
      }
    }
    /**
     * <code>repeated .com.mbrdi.protobufs.CustomerProto customers = 3;</code>
     */
    public com.mbrdi.protobufs.CustomerProto getCustomers(int index) {
      if (customersBuilder_ == null) {
        return customers_.get(index);
      } else {
        return customersBuilder_.getMessage(index);
      }
    }
    /**
     * <code>repeated .com.mbrdi.protobufs.CustomerProto customers = 3;</code>
     */
    public Builder setCustomers(
        int index, com.mbrdi.protobufs.CustomerProto value) {
      if (customersBuilder_ == null) {
        if (value == null) {
          throw new NullPointerException();
        }
        ensureCustomersIsMutable();
        customers_.set(index, value);
        onChanged();
      } else {
        customersBuilder_.setMessage(index, value);
      }
      return this;
    }
    /**
     * <code>repeated .com.mbrdi.protobufs.CustomerProto customers = 3;</code>
     */
    public Builder setCustomers(
        int index, com.mbrdi.protobufs.CustomerProto.Builder builderForValue) {
      if (customersBuilder_ == null) {
        ensureCustomersIsMutable();
        customers_.set(index, builderForValue.build());
        onChanged();
      } else {
        customersBuilder_.setMessage(index, builderForValue.build());
      }
      return this;
    }
    /**
     * <code>repeated .com.mbrdi.protobufs.CustomerProto customers = 3;</code>
     */
    public Builder addCustomers(com.mbrdi.protobufs.CustomerProto value) {
      if (customersBuilder_ == null) {
        if (value == null) {
          throw new NullPointerException();
        }
        ensureCustomersIsMutable();
        customers_.add(value);
        onChanged();
      } else {
        customersBuilder_.addMessage(value);
      }
      return this;
    }
    /**
     * <code>repeated .com.mbrdi.protobufs.CustomerProto customers = 3;</code>
     */
    public Builder addCustomers(
        int index, com.mbrdi.protobufs.CustomerProto value) {
      if (customersBuilder_ == null) {
        if (value == null) {
          throw new NullPointerException();
        }
        ensureCustomersIsMutable();
        customers_.add(index, value);
        onChanged();
      } else {
        customersBuilder_.addMessage(index, value);
      }
      return this;
    }
    /**
     * <code>repeated .com.mbrdi.protobufs.CustomerProto customers = 3;</code>
     */
    public Builder addCustomers(
        com.mbrdi.protobufs.CustomerProto.Builder builderForValue) {
      if (customersBuilder_ == null) {
        ensureCustomersIsMutable();
        customers_.add(builderForValue.build());
        onChanged();
      } else {
        customersBuilder_.addMessage(builderForValue.build());
      }
      return this;
    }
    /**
     * <code>repeated .com.mbrdi.protobufs.CustomerProto customers = 3;</code>
     */
    public Builder addCustomers(
        int index, com.mbrdi.protobufs.CustomerProto.Builder builderForValue) {
      if (customersBuilder_ == null) {
        ensureCustomersIsMutable();
        customers_.add(index, builderForValue.build());
        onChanged();
      } else {
        customersBuilder_.addMessage(index, builderForValue.build());
      }
      return this;
    }
    /**
     * <code>repeated .com.mbrdi.protobufs.CustomerProto customers = 3;</code>
     */
    public Builder addAllCustomers(
        java.lang.Iterable<? extends com.mbrdi.protobufs.CustomerProto> values) {
      if (customersBuilder_ == null) {
        ensureCustomersIsMutable();
        com.google.protobuf.AbstractMessageLite.Builder.addAll(
            values, customers_);
        onChanged();
      } else {
        customersBuilder_.addAllMessages(values);
      }
      return this;
    }
    /**
     * <code>repeated .com.mbrdi.protobufs.CustomerProto customers = 3;</code>
     */
    public Builder clearCustomers() {
      if (customersBuilder_ == null) {
        customers_ = java.util.Collections.emptyList();
        bitField0_ = (bitField0_ & ~0x00000004);
        onChanged();
      } else {
        customersBuilder_.clear();
      }
      return this;
    }
    /**
     * <code>repeated .com.mbrdi.protobufs.CustomerProto customers = 3;</code>
     */
    public Builder removeCustomers(int index) {
      if (customersBuilder_ == null) {
        ensureCustomersIsMutable();
        customers_.remove(index);
        onChanged();
      } else {
        customersBuilder_.remove(index);
      }
      return this;
    }
    /**
     * <code>repeated .com.mbrdi.protobufs.CustomerProto customers = 3;</code>
     */
    public com.mbrdi.protobufs.CustomerProto.Builder getCustomersBuilder(
        int index) {
      return getCustomersFieldBuilder().getBuilder(index);
    }
    /**
     * <code>repeated .com.mbrdi.protobufs.CustomerProto customers = 3;</code>
     */
    public com.mbrdi.protobufs.CustomerProtoOrBuilder getCustomersOrBuilder(
        int index) {
      if (customersBuilder_ == null) {
        return customers_.get(index);  } else {
        return customersBuilder_.getMessageOrBuilder(index);
      }
    }
    /**
     * <code>repeated .com.mbrdi.protobufs.CustomerProto customers = 3;</code>
     */
    public java.util.List<? extends com.mbrdi.protobufs.CustomerProtoOrBuilder> 
         getCustomersOrBuilderList() {
      if (customersBuilder_ != null) {
        return customersBuilder_.getMessageOrBuilderList();
      } else {
        return java.util.Collections.unmodifiableList(customers_);
      }
    }
    /**
     * <code>repeated .com.mbrdi.protobufs.CustomerProto customers = 3;</code>
     */
    public com.mbrdi.protobufs.CustomerProto.Builder addCustomersBuilder() {
      return getCustomersFieldBuilder().addBuilder(
          com.mbrdi.protobufs.CustomerProto.getDefaultInstance());
    }
    /**
     * <code>repeated .com.mbrdi.protobufs.CustomerProto customers = 3;</code>
     */
    public com.mbrdi.protobufs.CustomerProto.Builder addCustomersBuilder(
        int index) {
      return getCustomersFieldBuilder().addBuilder(
          index, com.mbrdi.protobufs.CustomerProto.getDefaultInstance());
    }
    /**
     * <code>repeated .com.mbrdi.protobufs.CustomerProto customers = 3;</code>
     */
    public java.util.List<com.mbrdi.protobufs.CustomerProto.Builder> 
         getCustomersBuilderList() {
      return getCustomersFieldBuilder().getBuilderList();
    }
    private com.google.protobuf.RepeatedFieldBuilderV3<
        com.mbrdi.protobufs.CustomerProto, com.mbrdi.protobufs.CustomerProto.Builder, com.mbrdi.protobufs.CustomerProtoOrBuilder> 
        getCustomersFieldBuilder() {
      if (customersBuilder_ == null) {
        customersBuilder_ = new com.google.protobuf.RepeatedFieldBuilderV3<
            com.mbrdi.protobufs.CustomerProto, com.mbrdi.protobufs.CustomerProto.Builder, com.mbrdi.protobufs.CustomerProtoOrBuilder>(
                customers_,
                ((bitField0_ & 0x00000004) != 0),
                getParentForChildren(),
                isClean());
        customers_ = null;
      }
      return customersBuilder_;
    }
    @java.lang.Override
    public final Builder setUnknownFields(
        final com.google.protobuf.UnknownFieldSet unknownFields) {
      return super.setUnknownFields(unknownFields);
    }

    @java.lang.Override
    public final Builder mergeUnknownFields(
        final com.google.protobuf.UnknownFieldSet unknownFields) {
      return super.mergeUnknownFields(unknownFields);
    }


    // @@protoc_insertion_point(builder_scope:com.mbrdi.protobufs.CustomerTransferProto)
  }

  // @@protoc_insertion_point(class_scope:com.mbrdi.protobufs.CustomerTransferProto)
  private static final com.mbrdi.protobufs.CustomerTransferProto DEFAULT_INSTANCE;
  static {
    DEFAULT_INSTANCE = new com.mbrdi.protobufs.CustomerTransferProto();
  }

  public static com.mbrdi.protobufs.CustomerTransferProto getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final com.google.protobuf.Parser<CustomerTransferProto>
      PARSER = new com.google.protobuf.AbstractParser<CustomerTransferProto>() {
    @java.lang.Override
    public CustomerTransferProto parsePartialFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return new CustomerTransferProto(input, extensionRegistry);
    }
  };

  public static com.google.protobuf.Parser<CustomerTransferProto> parser() {
    return PARSER;
  }

  @java.lang.Override
  public com.google.protobuf.Parser<CustomerTransferProto> getParserForType() {
    return PARSER;
  }

  @java.lang.Override
  public com.mbrdi.protobufs.CustomerTransferProto getDefaultInstanceForType() {
    return DEFAULT_INSTANCE;
  }

}
