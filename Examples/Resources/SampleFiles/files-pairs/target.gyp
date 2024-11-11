  {
    'targets': [
      {
        'target_name': 'new_library',
        'type': '<(library)',
        'defines': [
          'BOO',
          'RAR=get_some_value',
        ],
        'include_dirs': [
          '..',
        ],
        'dependencies': [
          'other_source_in_this_file',
          'other_gyp2:target_in_other_gyp2',
        ],
        'direct_dependent_settings': {
          'include_dirs': '.',
        },
        'export_dependent_settings': [
          'other_target_in_this_file',
        ],
        'sources': [
          'new_additional_source.cc',
          'new_library.cc',
        ],
      },
    ],
  }