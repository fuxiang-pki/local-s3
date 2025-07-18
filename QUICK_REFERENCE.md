# LocalS3 Quick Feature Reference

## Supported S3 Operations

| Category | Operation | Status | Notes |
|----------|-----------|--------|-------|
| **Object Operations** | PutObject | ✅ | Full support |
| | GetObject | ✅ | Full support |
| | HeadObject | ✅ | Full support |
| | DeleteObject | ✅ | Full support |
| | CopyObject | ✅ | Full support |
| | ListObjects | ✅ | V1 API |
| | ListObjectVersions | ✅ | Full support |
| **Bucket Operations** | CreateBucket | ✅ | Basic implementation |
| | DeleteBucket | ✅ | Full support |
| | HeadBucket | ✅ | Full support |
| | ListBuckets | ❌ | Not implemented |
| **Multipart Upload** | CreateMultipartUpload | ✅ | Full support |
| | UploadPart | ✅ | Full support |
| | CompleteMultipartUpload | ✅ | Full support |
| | AbortMultipartUpload | ❌ | Not implemented |
| | ListMultipartUploads | ❌ | Not implemented |
| | ListParts | ❌ | Not implemented |
| **Access Control** | GetBucketAcl | ✅ | Basic implementation |
| | PutBucketAcl | ✅ | Basic implementation |
| | GetObjectAcl | ❌ | Not implemented |
| | PutObjectAcl | ❌ | Not implemented |
| **Bucket Policies** | GetBucketPolicy | ✅ | Full support |
| | PutBucketPolicy | ✅ | Full support |
| | DeleteBucketPolicy | ✅ | Full support |
| **Versioning** | GetBucketVersioning | ✅ | Full support |
| | PutBucketVersioning | ✅ | Full support |
| **Tagging** | GetBucketTagging | ✅ | Full support |
| | PutBucketTagging | ✅ | Full support |
| | DeleteBucketTagging | ✅ | Full support |
| | GetObjectTagging | ❌ | Not implemented |
| | PutObjectTagging | ❌ | Not implemented |
| | DeleteObjectTagging | ❌ | Not implemented |

## Major Missing Feature Categories

| Category | Examples | Impact |
|----------|----------|---------|
| **Storage Classes** | Standard-IA, Glacier, Deep Archive | Cannot test cost optimization |
| **Encryption** | SSE-S3, SSE-KMS, SSE-C | Cannot test security scenarios |
| **Lifecycle Management** | Transitions, Expiration | Cannot test automated archival |
| **Cross-Region Features** | Replication, Transfer Acceleration | Cannot test global scenarios |
| **Event Notifications** | SNS, SQS, Lambda triggers | Cannot test event-driven apps |
| **Advanced Security** | IAM, Object Lock, VPC endpoints | Cannot test enterprise security |
| **Analytics** | Storage Class Analysis, Inventory | Cannot test optimization |
| **Website Hosting** | Static website configuration | Cannot test web scenarios |

## Compatibility Notes

- **API Version**: Implements a subset of S3 REST API
- **Authentication**: Simplified (no AWS signatures)
- **Regions**: Basic region support
- **Error Codes**: Limited error code coverage
- **Headers**: Basic S3 headers supported
- **Query Parameters**: Limited parameter support

For detailed information, see [FEATURE_COMPARISON.md](FEATURE_COMPARISON.md).