#ifndef UTIL_FILE_H
#define UTIL_FILE_H

#include "util/exception.hh"
#include "util/scoped.hh"
#include "util/string_piece.hh"

#include <cstddef>
#include <cstdio>
#include <string>
#include <stdint.h>

namespace util {

class scoped_fd {
  public:
    scoped_fd() : fd_(-1) {}

    explicit scoped_fd(int fd) : fd_(fd) {}

    ~scoped_fd();

#if __cplusplus >= 201103L
    scoped_fd(scoped_fd &&from) noexcept : fd_(from.fd_) {
      from.fd_ = -1;
    }
#endif

    void reset(int to = -1) {
      scoped_fd other(fd_);
      fd_ = to;
    }

    int get() const { return fd_; }

    int operator*() const { return fd_; }

    int release() {
      int ret = fd_;
      fd_ = -1;
      return ret;
    }

  private:
    int fd_;

    scoped_fd(const scoped_fd &);
    scoped_fd &operator=(const scoped_fd &);
};

struct scoped_FILE_closer {
  static void Close(std::FILE *file);
};

// End of file reached.
class EndOfFileException : public Exception {
  public:
    EndOfFileException() throw();
    ~EndOfFileException() throw();
};

class UnsupportedOSException : public Exception {};

// Open for read only.
int OpenReadOrThrow(const char *name);
// Create file if it doesn't exist, truncate if it does.  Opened for write.
int CreateOrThrow(const char *name);

/** Does the given input file path denote standard input?
 *
 * Returns true if, and only if, path is either "-" or "/dev/stdin".
 *
 * Opening standard input as a file may need some special treatment for
 * portability.  There's a convention that a dash ("-") in place of an input
 * file path denotes standard input, but opening "/dev/stdin" may need to be
 * special as well.
 */
bool InputPathIsStdin(StringPiece path);

/** Does the given output file path denote standard output?
 *
 * Returns true if, and only if, path is either "-" or "/dev/stdout".
 *
 * Opening standard output as a file may need some special treatment for
 * portability.  There's a convention that a dash ("-") in place of an output
 * file path denotes standard output, but opening "/dev/stdout" may need to be
 * special as well.
 */
bool OutputPathIsStdout(StringPiece path);

// Return value for SizeFile when it can't size properly.
const uint64_t kBadSize = (uint64_t)-1;
uint64_t SizeFile(int fd);
uint64_t SizeOrThrow(int fd);

void ResizeOrThrow(int fd, uint64_t to);


std::size_t PartialRead(int fd, void *to, std::size_t size);
void ReadOrThrow(int fd, void *to, std::size_t size);
std::size_t ReadOrEOF(int fd, void *to_void, std::size_t size);

void WriteOrThrow(int fd, const void *data_void, std::size_t size);
void WriteOrThrow(FILE *to, const void *data, std::size_t size);

void ErsatzPRead(int fd, void *to, std::size_t size, uint64_t off);
void ErsatzPWrite(int fd, const void *data_void, std::size_t size, uint64_t off);

void FSyncOrThrow(int fd);

// Seeking: returns offset
uint64_t SeekOrThrow(int fd, uint64_t off);
uint64_t AdvanceOrThrow(int fd, int64_t off);
uint64_t SeekEnd(int fd);

std::FILE *FDOpenOrThrow(scoped_fd &file);
std::FILE *FDOpenReadOrThrow(scoped_fd &file);

// Where should we put temporary files?  Handles all the windows/POSIX defaults fun.
std::string DefaultTempDirectory();

// dup an fd.
int DupOrThrow(int fd);

/* Attempt get file name from fd.  This won't always work (i.e. on Windows or
 * a pipe).  The file might have been renamed.  It's intended for diagnostics
 * and logging only.
 */
std::string NameFromFD(int fd);

} // namespace util

#endif // UTIL_FILE_H