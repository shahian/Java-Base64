# Java-Base64
Base64 is a binary-to-text encoding scheme that represents binary data in a printable ASCII string format by translating it into a radix-64 representation. Each Base64 digit represents exactly 6 bits of binary data.
Base64 encoding and decoding
Base64 relies on simple encoding and decoding algorithms. They work with a 65-character subset of US-ASCII where each of the first 64 characters maps to an equivalent 6-bit binary sequence. 
Java 8 introduced a Base64 API consisting of the java.util.Base64 class along with its Encoder and Decoder nested static classes. Base64 presents several static methods for obtaining encoders and decoders:

Base64.Encoder getEncoder(): Return an encoder for the Basic variant.
Base64.Decoder getDecoder(): Return a decoder for the Basic variant.
Base64.Encoder getMimeEncoder(): Return an encoder for the MIME variant.
Base64.Encoder getMimeEncoder(int lineLength, byte[] lineSeparator): Return an encoder for a modified MIME variant with the given lineLength (rounded down to the nearest multiple of 4 -- output not separated into lines when lineLength <= 0) and lineSeparator. It throws java.lang.IllegalArgumentException when lineSeparator includes any Base64 alphabet character presented in Table 1 of RFC 2045. RFC 2045's encoder, which is returned from the noargument getMimeEncoder() method, is rather rigid. For example, that encoder creates encoded text with fixed line lengths (except for the last line) of 76 characters. If you want an encoder to support RFC 1421, which dicates a fixed line length of 64 characters, you need to use getMimeEncoder(int lineLength, byte[] lineSeparator).
Base64.Decoder getMimeDecoder(): Return a decoder for the MIME variant.
Base64.Encoder getUrlEncoder(): Return an encoder for the URL and Filename Safe variant.
Base64.Decoder getUrlDecoder(): Return a decoder for the URL and Filename Safe variant.
Base64.Encoder presents several threadsafe instance methods for encoding byte sequences. Passing the null reference to one of the following methods results in java.lang.NullPointerException:

byte[] encode(byte[] src): Encode all bytes in src to a newly-allocated byte array, which this method returns.
int encode(byte[] src, byte[] dst): Encode all bytes in src to dst (starting at offset 0). If dst isn't big enough to hold the encoding, IllegalArgumentException is thrown. Otherwise, the number of bytes written to dst is returned.
ByteBuffer encode(ByteBuffer buffer): Encode all remaining bytes in buffer to a newly-allocated java.nio.ByteBuffer object. Upon return, buffer's position will be updated to its limit; its limit won't have been changed. The returned output buffer's position will be zero and its limit will be the number of resulting encoded bytes.
String encodeToString(byte[] src): Encode all bytes in src to a string, which is returned. Invoking this method is equivalent to executing new String(encode(src), StandardCharsets.ISO_8859_1).
Base64.Encoder withoutPadding(): Return an encoder that encodes equivalently to this encoder, but without adding any padding character at the end of the encoded byte data.
OutputStream wrap(OutputStream os): Wrap an output stream for encoding byte data. It's recommended to promptly close the returned output stream after use, during which it will flush all possible leftover bytes to the underlying output stream. Closing the returned output stream will close the underlying output stream.
