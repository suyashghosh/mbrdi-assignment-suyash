// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: customer_proto.proto

package com.mbrdi.protobufs;

public interface CustomerProtoOrBuilder extends
    // @@protoc_insertion_point(interface_extends:com.mbrdi.protobufs.CustomerProto)
    com.google.protobuf.MessageOrBuilder {

  /**
   * <code>optional int32 id = 1;</code>
   * @return Whether the id field is set.
   */
  boolean hasId();
  /**
   * <code>optional int32 id = 1;</code>
   * @return The id.
   */
  int getId();

  /**
   * <code>optional string name = 2;</code>
   * @return Whether the name field is set.
   */
  boolean hasName();
  /**
   * <code>optional string name = 2;</code>
   * @return The name.
   */
  java.lang.String getName();
  /**
   * <code>optional string name = 2;</code>
   * @return The bytes for name.
   */
  com.google.protobuf.ByteString
      getNameBytes();

  /**
   * <code>optional string dob = 3;</code>
   * @return Whether the dob field is set.
   */
  boolean hasDob();
  /**
   * <code>optional string dob = 3;</code>
   * @return The dob.
   */
  java.lang.String getDob();
  /**
   * <code>optional string dob = 3;</code>
   * @return The bytes for dob.
   */
  com.google.protobuf.ByteString
      getDobBytes();

  /**
   * <code>optional string salary = 4;</code>
   * @return Whether the salary field is set.
   */
  boolean hasSalary();
  /**
   * <code>optional string salary = 4;</code>
   * @return The salary.
   */
  java.lang.String getSalary();
  /**
   * <code>optional string salary = 4;</code>
   * @return The bytes for salary.
   */
  com.google.protobuf.ByteString
      getSalaryBytes();

  /**
   * <code>optional int32 age = 5;</code>
   * @return Whether the age field is set.
   */
  boolean hasAge();
  /**
   * <code>optional int32 age = 5;</code>
   * @return The age.
   */
  int getAge();
}
